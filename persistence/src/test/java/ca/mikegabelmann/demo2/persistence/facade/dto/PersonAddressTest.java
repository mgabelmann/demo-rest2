package ca.mikegabelmann.demo2.persistence.facade.dto;

import ca.mikegabelmann.demo2.persistence.model.Address;
import ca.mikegabelmann.demo2.persistence.model.ModelFactory;
import ca.mikegabelmann.demo2.persistence.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class PersonAddressTest {

    @Test
    @DisplayName("no args constructor - invalid arguments")
    void test1_constructor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new PersonAddress(null));
    }

    @Test
    void getPerson() {
        Person person1 = ModelFactory.getPerson_Male();
        PersonAddress personAddress1 = new PersonAddress(person1, null, null);

        Assertions.assertNotNull(personAddress1.getPerson());
    }

    @Test
    void getPrimaryAddress() {
        Person person1 = ModelFactory.getPerson_Male();
        Address address1 = ModelFactory.getAddress(person1);
        PersonAddress personAddress1 = new PersonAddress(person1, address1, null);

        Assertions.assertTrue(personAddress1.getPrimaryAddress().isPresent());
        Assertions.assertTrue(personAddress1.getSecondaryAddress().isEmpty());
    }

    @Test
    void getSecondaryAddress() {
        Person person1 = ModelFactory.getPerson_Male();
        Address address1 = ModelFactory.getAddress(person1);
        PersonAddress personAddress1 = new PersonAddress(person1, null, address1);

        Assertions.assertTrue(personAddress1.getPrimaryAddress().isEmpty());
        Assertions.assertTrue(personAddress1.getSecondaryAddress().isPresent());
    }

}
