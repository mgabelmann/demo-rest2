package ca.mikegabelmann.demo2.persistence.facade;

import ca.mikegabelmann.demo2.persistence.model.Address;
import ca.mikegabelmann.demo2.persistence.model.ModelFactory;
import ca.mikegabelmann.demo2.persistence.model.Person;
import ca.mikegabelmann.demo2.persistence.repository.AddressRepository;
import ca.mikegabelmann.demo2.persistence.repository.PersonRepository;
import ca.mikegabelmann.demo2.persistence.facade.dto.PersonAddress;
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


@ExtendWith(MockitoExtension.class)
public class PersonFacadeImplTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private PersonFacadeImpl personFacade;

    private Person person;
    private Address address;


    @BeforeEach
    void beforeEach() {
        this.person = ModelFactory.getPerson_Male();
        this.address = ModelFactory.getAddress(person);
        person.getAddresses().add(address);
    }

    @Test
    @DisplayName("getPersonAddress - without results")
    void test1_getPersonAddress() {
        Optional<PersonAddress> result = personFacade.getPersonAddress(1L);

        Assertions.assertFalse(result.isPresent());
    }

    @Test
    @DisplayName("getPersonAddress - with results")
    void test2_getPersonAddress() {
        Mockito.when(personRepository.findById(1L)).thenReturn(Optional.of(person));

        Optional<PersonAddress> result = personFacade.getPersonAddress(1L);
        Assertions.assertTrue(result.isPresent());
        Assertions.assertNotNull(result.get().getPerson());
        Assertions.assertNotNull(result.get().getPrimaryAddress());
        Assertions.assertNotNull(result.get().getSecondaryAddress());
    }

}
