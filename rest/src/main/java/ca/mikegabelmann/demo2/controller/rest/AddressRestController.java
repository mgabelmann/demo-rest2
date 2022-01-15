package ca.mikegabelmann.demo2.controller.rest;

import ca.mikegabelmann.demo2.dto.AddressDto;
import ca.mikegabelmann.demo2.persistence.model.Address;
import ca.mikegabelmann.demo2.service.AddressService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class AddressRestController {
    /** Logger. */
    private static final Logger LOG = LogManager.getLogger(AddressRestController.class);

    /** Person service. */
    private final AddressService addressService;


    @Autowired
    public AddressRestController(AddressService addressService) {
        this.addressService = addressService;
    }

    //TODO: implement methods here

    /**
     * Map a collection of domain objects to DTOs.
     * @param records domain records
     * @return transfer records
     */
    public static List<AddressDto> map(List<Address> records) {
        if (records != null) {
            return records.stream().map(AddressRestController::map).collect(Collectors.toList());

        } else {
            return null;
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
