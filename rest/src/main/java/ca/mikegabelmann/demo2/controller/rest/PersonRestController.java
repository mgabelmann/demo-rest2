package ca.mikegabelmann.demo2.controller.rest;

import ca.mikegabelmann.demo2.codes.Sex;
import ca.mikegabelmann.demo2.persistence.model.Person;
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
import java.util.stream.Collectors;


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

        List<Person> results = personService.findBySexAndBirthDt(sex.name(), date);

        return ResponseEntity.ok(PersonRestController.map(results));
    }

    /* NOTE: Spring converts values inside PersonSearch1 into a PersonSearch1 for us which makes adding new parameters
     *       easier since we don't have to change our method signature, versioning API, etc.
     *
     * NOTE: can't use a @RequestParam here since Spring is doing some magic here
     */
    @GetMapping(path = PersonRestController.PATH_PERSONS_SEARCH1)
    public ResponseEntity<List<PersonDto>> findBySexAndBirthDt(
        PersonSearch1 search) {

        List<Person> results = personService.findBySexAndBirthDt(search.getSex().name(), search.getDate());

        return ResponseEntity.ok(PersonRestController.map(results));
    }

    /**
     * Map a collection of domain objects to DTOs.
     * @param records domain records
     * @return transfer records
     */
    public static List<PersonDto> map(List<Person> records) {
        if (records != null) {
            return records.stream().map(PersonRestController::map).collect(Collectors.toList());

        } else {
            return null;
        }
    }

    /**
     * Convert Person to PersonDto.
     * @param p record
     * @return mapped record
     */
    public static PersonDto map(Person p) {
        PersonDto tmp;

        if (p != null) {
            tmp = new PersonDto(p.getId(), p.getFirstName(), p.getLastName(), p.getMiddleName(), p.getBirthDt(), p.getSexCode().getId());

        } else {
            tmp = null;
        }

        return tmp;
    }

}
