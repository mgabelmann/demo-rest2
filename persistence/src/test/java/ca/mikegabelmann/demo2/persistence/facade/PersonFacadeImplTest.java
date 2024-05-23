package ca.mikegabelmann.demo2.persistence.facade;

import ca.mikegabelmann.demo2.persistence.model.Address;
import ca.mikegabelmann.demo2.persistence.model.ModelTestFactory;
import ca.mikegabelmann.demo2.persistence.model.Person;
import ca.mikegabelmann.demo2.persistence.repository.PersonRepository;
import ca.mikegabelmann.demo2.persistence.facade.bean.PersonAddress;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;


@ExtendWith(MockitoExtension.class)
public class PersonFacadeImplTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonFacadeImpl personFacade;

    private Person person;
    private Address address;


    @BeforeEach
    void beforeEach() {
        this.person = ModelTestFactory.getPerson_Male();
        this.address = ModelTestFactory.getAddress(person);
        person.getAddresses().add(address);
    }

    @Test
    @DisplayName("getPersonAddress - without results")
    void test1_getPersonAddress() {
        Optional<PersonAddress> result = personFacade.getPersonAddress(UUID.randomUUID());

        Assertions.assertFalse(result.isPresent());
    }

    @Test
    @DisplayName("getPersonAddress - with results")
    void test2_getPersonAddress() {

        Mockito.when(personRepository.findById(person.getId())).thenReturn(Optional.of(person));

        Optional<PersonAddress> result = personFacade.getPersonAddress(person.getId());
        Assertions.assertTrue(result.isPresent());

        PersonAddress personAddress = result.get();
        Assertions.assertNotNull(personAddress.getPerson());

        Assertions.assertTrue(personAddress.getPrimaryAddress().isPresent());
        Assertions.assertTrue(personAddress.getSecondaryAddress().isEmpty());
    }

}
