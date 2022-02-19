package ca.mikegabelmann.demo2.controller.rest;

import ca.mikegabelmann.demo2.dto.AddressDto;
import ca.mikegabelmann.demo2.persistence.model.Address;
import ca.mikegabelmann.demo2.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class AddressRestController {
    /** Path for REST endpoint. */
    public static final String PATH_ADDRESS_SEARCH1 = "/addresses/search";

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(AddressRestController.class);

    /** Person service. */
    private final AddressService addressService;


    @Autowired
    public AddressRestController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(path = AddressRestController.PATH_ADDRESS_SEARCH1)
    public ResponseEntity<List<AddressDto>> getAddressByCountryAndProvAndCity(
        @RequestParam(value="country") String country,
        @RequestParam(value="prov") String prov,
        @RequestParam(value="city") String city) {

        List<Address> results = addressService.getAddressByCountryAndProvAndCity(country, prov, city);

        return ResponseEntity.ok(AddressRestController.map(results));
    }

    /**
     * Map a collection of domain objects to DTOs.
     * @param records domain records
     * @return transfer records
     */
    public static List<AddressDto> map(List<Address> records) {
        if (records != null) {
            return records.stream().map(AddressRestController::map).collect(Collectors.toList());

        } else {
            return List.of();
        }
    }

    /**
     * Convert Address to AddressDto.
     * @param a record
     * @return mapped record
     */
    public static AddressDto map(Address a) {
        AddressDto tmp;

        if (a != null) {
            tmp = new AddressDto(a.getId(), a.getAttention(), a.getStreetAddress(), a.getCity(), a.getProv(), a.getCountry(), a.getPostal());

        } else {
            tmp = null;
        }

        return tmp;
    }

}
