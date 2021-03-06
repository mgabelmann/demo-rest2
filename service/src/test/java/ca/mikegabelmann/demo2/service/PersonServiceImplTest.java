package ca.mikegabelmann.demo2.service;

import ca.mikegabelmann.demo2.persistence.model.Person;
import ca.mikegabelmann.demo2.persistence.model.SexCode;
import ca.mikegabelmann.demo2.persistence.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonServiceImpl service;

    private Person p;


    @BeforeEach
    void beforeEach() {
        SexCode sex = new SexCode("M", "Male");
        this.p = new Person(1L, "firstName", "lastName", LocalDate.now(), sex);
    }

    @Test
    @DisplayName("findBySexAndBirthDt - with results")
    void test1_findBySexAndBirthDt() {
        Mockito.when(personRepository.findBySexCodeIdAndBirthDt("M", p.getBirthDt())).thenReturn(List.of(p));

        List<Person> results = service.findBySexAndBirthDt("M", LocalDate.now());

        Assertions.assertNotNull(results);
        Assertions.assertEquals(1, results.size());
    }

}