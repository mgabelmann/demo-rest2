package ca.mikegabelmann.demo2.controller.rest;

import ca.mikegabelmann.demo2.codes.Sex;
import ca.mikegabelmann.demo2.search.PersonSearch1;
import ca.mikegabelmann.demo2.service.PersonService;
import ca.mikegabelmann.demo2.dto.PersonDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
public final class PersonRestController {
    /** Path for REST endpoint. */
    public static final String PATH_PERSONS_SEARCH = "/persons/search";

    /** Path for REST endpoint. */
    public static final String PATH_PERSONS_SEARCH1 = "/persons/search1";

    /** Logger. */
    private static final Logger LOG = LogManager.getLogger(PersonRestController.class);

    /** Person service. */
    private final PersonService personService;


    @Autowired
    public PersonRestController(final PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = PersonRestController.PATH_PERSONS_SEARCH)
    public ResponseEntity<List<PersonDto>> findBySexAndBirthDt(
        @RequestParam(value="sex") Sex sex,
        @RequestParam(value="date") LocalDate date) {

        List<PersonDto> results = personService.findBySexAndBirthDt(sex.name(), date);

        return ResponseEntity.ok(results);
    }

    /* NOTE: Spring converts values inside PersonSearch1 into a PersonSearch1 for us which makes adding new parameters
     *       easier since we don't have to change our method signature, versioning API, etc.
     *
     * NOTE: can't use a @RequestParam here since Spring is doing some magic here
     */
    @GetMapping(path = PersonRestController.PATH_PERSONS_SEARCH1)
    public ResponseEntity<List<PersonDto>> findBySexAndBirthDt(
        PersonSearch1 search) {

        List<PersonDto> results = personService.findBySexAndBirthDt(search.getSex().name(), search.getDate());

        return ResponseEntity.ok(results);
    }

}
