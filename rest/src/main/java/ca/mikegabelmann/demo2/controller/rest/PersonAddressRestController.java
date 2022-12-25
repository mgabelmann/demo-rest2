package ca.mikegabelmann.demo2.controller.rest;

import ca.mikegabelmann.demo2.controller.rest.mapper.DtoMapper;
import ca.mikegabelmann.demo2.dto.AddressDto;
import ca.mikegabelmann.demo2.dto.PersonAddressDto;
import ca.mikegabelmann.demo2.dto.PersonDto;
import ca.mikegabelmann.demo2.persistence.facade.PersonFacade;
import ca.mikegabelmann.demo2.persistence.service.dto.PersonAddress;
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


    //NOTE: we have to do this because Mapstruct doesn't handle Optional<T> easily or well


    public List<PersonAddressDto> map(List<PersonAddress> records) {
        if (records != null) {
            return records.stream().map(this::map).collect(Collectors.toList());

        } else {
            return List.of();
        }
    }

    public PersonAddressDto map(PersonAddress pa) {
        if (pa != null) {
            PersonDto p = dtoMapper.mapPersonDto(pa.getPerson());
            AddressDto a1 = pa.getPrimaryAddress().isPresent() ? dtoMapper.mapAddressDto(pa.getPrimaryAddress().get()) : null;
            AddressDto a2 = pa.getSecondaryAddress().isPresent() ? dtoMapper.mapAddressDto(pa.getSecondaryAddress().get()) : null;

            return new PersonAddressDto(p, a1, a2);

        } else {
            return null;
        }
    }

}
