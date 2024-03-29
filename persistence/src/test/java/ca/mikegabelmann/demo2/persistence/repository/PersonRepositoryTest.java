package ca.mikegabelmann.demo2.persistence.repository;

import ca.mikegabelmann.demo2.persistence.model.Person;
import ca.mikegabelmann.demo2.persistence.model.SexCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;


@DataJpaTest
public class PersonRepositoryTest {

    private final SexCodeRepository sexCodeRepository;
    private final PersonRepository personRepository;

    private SexCode s;
    private Person p;


    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    public PersonRepositoryTest(SexCodeRepository sexCodeRepository, PersonRepository personRepository) {
        this.sexCodeRepository = sexCodeRepository;
        this.personRepository = personRepository;
    }

    @BeforeEach
    void beforeEach() {
        SexCode sTmp = new SexCode("M", "Male");
        this.s = sexCodeRepository.save(sTmp);

        Person pTmp = new Person(null, "firstName", "lastName", LocalDate.now(), s);
        this.p = personRepository.save(pTmp);

        //sexcode does not have a generated ID
        Assertions.assertNotNull(p.getId());
    }

    @Test
    @DisplayName("getReferenceById - with result")
    void test1_getReferenceById() {
        Person result = personRepository.getReferenceById(p.getId());

        Assertions.assertNotNull(result);
    }

    @Test
    @DisplayName("findBySexAndBirthDt - with results")
    void test1_findBySexAndBirthDt() {
        List<Person> records = personRepository.findBySexCodeIdAndBirthDt("M", LocalDate.now());

        Assertions.assertNotNull(records);
        Assertions.assertEquals(1, records.size());
    }

    @Test
    @DisplayName("findBySexAndBirthDt - without results")
    void test2_findBySexAndBirthDt() {
        List<Person> records = personRepository.findBySexCodeIdAndBirthDt("F", LocalDate.now());

        Assertions.assertNotNull(records);
        Assertions.assertEquals(0, records.size());
    }

}
