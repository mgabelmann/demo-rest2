package ca.mikegabelmann.demo2.controller.rest;

import ca.mikegabelmann.demo2.persistence.model.Sex;
import ca.mikegabelmann.demo2.controller.search.PersonSearch1;
import ca.mikegabelmann.demo2.service.PersonService;
import ca.mikegabelmann.demo2.dto.PersonDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


@RestController
public class PersonRestController {
    /** Logger. */
    private static final Logger LOG = LogManager.getLogger(PersonRestController.class);

    private final PersonService personService;


    @Autowired
    public PersonRestController(final PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/persons/search")
    public ResponseEntity<List<PersonDto>> findBySexAndBirthDt(Sex sex, LocalDate date) {
        List<PersonDto> results = personService.findBySexAndBirthDt(sex, date);

        return ResponseEntity.ok(results);
    }

    @GetMapping(path = "/persons/search1")
    public ResponseEntity<List<PersonDto>> findBySexAndBirthDt(PersonSearch1 search) {
        List<PersonDto> results = personService.findBySexAndBirthDt(search.getSex(), search.getDate());

        return ResponseEntity.ok(results);
    }

}
