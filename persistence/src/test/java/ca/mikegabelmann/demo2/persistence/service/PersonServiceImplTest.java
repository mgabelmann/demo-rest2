package ca.mikegabelmann.demo2.persistence.service;

import ca.mikegabelmann.demo2.persistence.model.ModelTestFactory;
import ca.mikegabelmann.demo2.persistence.model.Person;
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
        this.p = ModelTestFactory.getPerson_Male();
    }

    @Test
    @DisplayName("findBySexAndBirthDt - with results")
    void test1_findBySexAndBirthDt() {
        Mockito.when(personRepository.findBySexCodeIdAndBirthDt("M", p.getBirthDt())).thenReturn(List.of(p));

        List<Person> results = service.findBySexAndBirthDt("M", LocalDate.now());

        Assertions.assertNotNull(results);
        Assertions.assertEquals(1, results.size());
    }

    /*@Test
    @DisplayName("createOrUpdate - with result")
    void test1_createOrUpdate() {
        //NOTE: this test is effectively useless since it doesn't exercise any logic and only returns mocked results.
        Mockito.when(personRepository.save(p)).thenReturn(p);

        Person tmp = service.createOrUpdate(p);

        Assertions.assertNotNull(tmp);
    }*/
}