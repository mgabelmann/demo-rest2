package ca.mikegabelmann.demo2.controller.rest;

import ca.mikegabelmann.demo2.controller.rest.mapper.DtoMapper;
import ca.mikegabelmann.demo2.dto.AddressDto;
import ca.mikegabelmann.demo2.persistence.model.Address;
import ca.mikegabelmann.demo2.persistence.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class AddressRestController {
    /** Path for REST endpoint. */
    public static final String PATH_ADDRESS_SEARCH1 = "/addresses/search";

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(AddressRestController.class);

    /** Person service. */
    private final AddressService addressService;

    private final DtoMapper dtoMapper;


    @Autowired
    public AddressRestController(final AddressService addressService, final DtoMapper dtoMapper) {
        this.addressService = addressService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping(path = AddressRestController.PATH_ADDRESS_SEARCH1)
    public ResponseEntity<List<AddressDto>> getAddressByCountryAndProvAndCity(
        @RequestParam(value="country") String country,
        @RequestParam(value="prov") String prov,
        @RequestParam(value="city") String city) {

        List<Address> results = addressService.getAddressByCountryAndProvAndCity(country, prov, city);

        return ResponseEntity.ok(this.map(results));
    }

    private List<AddressDto> map(final List<Address> records) {
        return dtoMapper.mapListAddressDto(records);
    }

}
