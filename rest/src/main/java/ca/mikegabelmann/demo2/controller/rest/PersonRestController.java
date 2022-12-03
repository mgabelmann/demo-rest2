package ca.mikegabelmann.demo2.controller.rest;

import ca.mikegabelmann.demo2.codes.Sex;
import ca.mikegabelmann.demo2.controller.rest.mapper.DtoMapper;
import ca.mikegabelmann.demo2.persistence.model.Person;
import ca.mikegabelmann.demo2.persistence.model.SexCode;
import ca.mikegabelmann.demo2.search.PersonSearch1;
import ca.mikegabelmann.demo2.service.PersonService;
import ca.mikegabelmann.demo2.dto.PersonDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


@RestController
public final class PersonRestController {
    /** Path for REST endpoint. */
    public static final String PATH_PERSONS_SEARCH = "/persons/search";

    /** Path for REST endpoint. */
    public static final String PATH_PERSONS_SEARCH1 = "/persons/search1";

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(PersonRestController.class);

    /** Person service. */
    private final PersonService personService;

    private final DtoMapper dtoMapper;


    @Autowired
    public PersonRestController(final PersonService personService, final DtoMapper dtoMapper) {
        this.personService = personService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping(path = PersonRestController.PATH_PERSONS_SEARCH)
    public ResponseEntity<List<PersonDto>> findBySexAndBirthDt(
        @RequestParam(value="sex") Sex sex,
        @RequestParam(value="date") LocalDate date) {

        List<Person> results = personService.findBySexAndBirthDt(sex.name(), date);

        return ResponseEntity.ok(this.map(results));
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

        return ResponseEntity.ok(this.map(results));
    }

    @PostMapping(path = "/createperson/")
    //public ResponseEntity<PersonDto> createPerson(@RequestParam PersonDto person) {
    public ResponseEntity<PersonDto> createPerson() {
        //LOG.info("received person={}", person);
        LOG.info("got to here");

        //Person tmp = dtoMapper.mapPerson(person);
        SexCode tmp2 = new SexCode("M", "Male");
        Person tmp = new Person(null, "Mike", "Gabelmann", LocalDate.now(), tmp2);

        tmp = personService.createOrUpdate(tmp);

        return ResponseEntity.ok(dtoMapper.mapPersonDto(tmp));
    }

    private List<PersonDto> map(final List<Person> records) {
        return dtoMapper.mapListPersonDto(records);
    }

}
