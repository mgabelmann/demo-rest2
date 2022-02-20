package ca.mikegabelmann.demo2.controller.rest;

import ca.mikegabelmann.demo2.dto.PersonAddressDto;
import ca.mikegabelmann.demo2.service.dto.PersonAddress;
import ca.mikegabelmann.demo2.service.facade.PersonFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
public class PersonAddressRestController {
    /** Path for REST endpoint. */
    public static final String PATH_GET_PERSONADDRESS = "/personAddress/{id}";

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(PersonAddressRestController.class);

    private final PersonFacade personFacade;


    @Autowired
    public PersonAddressRestController(final PersonFacade personFacade) {
        this.personFacade = personFacade;
    }

    @GetMapping(path = PersonAddressRestController.PATH_GET_PERSONADDRESS)
    public ResponseEntity<PersonAddressDto> getPersonAddress(@PathVariable("id") Long id) {
        Optional<PersonAddress> personAddress = personFacade.getPersonAddress(id);

        if (personAddress.isPresent()) {
            return ResponseEntity.ok(PersonAddressRestController.map(personAddress.get()));

        } else {
            throw new ResourceNotFoundException();
        }
    }

    public static List<PersonAddressDto> map(List<PersonAddress> records) {
        if (records != null) {
            return records.stream().map(PersonAddressRestController::map).collect(Collectors.toList());

        } else {
            return List.of();
        }
    }

    public static PersonAddressDto map(PersonAddress pa) {
        PersonAddressDto tmp;

        if (pa != null) {
            tmp = new PersonAddressDto(PersonRestController.map(pa.getPerson()), AddressRestController.map(pa.getPrimaryAddress().orElse(null)), AddressRestController.map(pa.getSecondaryAddress().orElse(null)));

        } else {
            tmp = null;
        }

        return tmp;
    }

}
