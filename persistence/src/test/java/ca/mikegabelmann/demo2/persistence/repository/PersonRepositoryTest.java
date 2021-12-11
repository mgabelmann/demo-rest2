package ca.mikegabelmann.demo2.persistence.repository;

import ca.mikegabelmann.demo2.persistence.model.Person;
import ca.mikegabelmann.demo2.persistence.model.Sex;
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
    @Autowired
    private PersonRepository personRepository;

    private Person p;


    @BeforeEach
    void beforeEach() {
        Person pTmp = new Person(null, "firstName", "lastName", LocalDate.now(), Sex.MALE);
        this.p = personRepository.save(pTmp);

        Assertions.assertNotNull(p.getId());
    }

    @Test
    @DisplayName("getById - with result")
    void test1_getById() {
        Person result = personRepository.getById(p.getId());

        Assertions.assertNotNull(result);
    }

    @Test
    @DisplayName("findBySexAndBirthDt - with results")
    void test1_findBySexAndBirthDt() {
        List<Person> records = personRepository.findBySexAndBirthDt(Sex.MALE, LocalDate.now());

        Assertions.assertNotNull(records);
        Assertions.assertEquals(1, records.size());
    }

    @Test
    @DisplayName("findBySexAndBirthDt - without results")
    void test2_findBySexAndBirthDt() {
        List<Person> records = personRepository.findBySexAndBirthDt(Sex.FEMALE, LocalDate.now());

        Assertions.assertNotNull(records);
        Assertions.assertEquals(0, records.size());
    }

}
