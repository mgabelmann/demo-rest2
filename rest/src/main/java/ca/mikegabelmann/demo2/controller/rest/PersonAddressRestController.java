package ca.mikegabelmann.demo2.controller.rest;

import ca.mikegabelmann.demo2.controller.rest.mapper.DtoMapper;
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

import java.util.Optional;


@RestController
public class PersonAddressRestController {
    /** Path for REST endpoint. */
    public static final String PATH_GET_PERSONADDRESS = "/personAddress/{id}";

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(PersonAddressRestController.class);

    private final PersonFacade personFacade;

    private final DtoMapper dtoMapper;


    @Autowired
    public PersonAddressRestController(final PersonFacade personFacade, final DtoMapper dtoMapper) {
        this.personFacade = personFacade;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping(path = PersonAddressRestController.PATH_GET_PERSONADDRESS)
    public ResponseEntity<PersonAddressDto> getPersonAddress(@PathVariable("id") Long id) {
        Optional<PersonAddress> personAddress = personFacade.getPersonAddress(id);

        if (personAddress.isPresent()) {
            return ResponseEntity.ok(this.map(personAddress.get()));

        } else {
            throw new ResourceNotFoundException();
        }
    }

    private PersonAddressDto map(PersonAddress record) {
        return dtoMapper.mapPersonAddressDto(record);
    }

}
