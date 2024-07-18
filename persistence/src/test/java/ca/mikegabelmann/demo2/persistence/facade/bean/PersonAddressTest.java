package ca.mikegabelmann.demo2.persistence.facade.bean;

import ca.mikegabelmann.demo2.persistence.model.Address;
import ca.mikegabelmann.demo2.persistence.model.ModelTestFactory;
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
        Person person1 = ModelTestFactory.getPerson_Male();
        PersonAddress personAddress1 = new PersonAddress(person1, null, null);

        Assertions.assertNotNull(personAddress1.getPerson());
    }

    @Test
    void getPrimaryAddress() {
        Person person1 = ModelTestFactory.getPerson_Male();
        Address address1 = ModelTestFactory.getAddress(person1);
        PersonAddress personAddress1 = new PersonAddress(person1, address1, null);

        Assertions.assertTrue(personAddress1.getPrimaryAddress().isPresent());
        Assertions.assertTrue(personAddress1.getSecondaryAddress().isEmpty());
    }

    @Test
    void getSecondaryAddress() {
        Person person1 = ModelTestFactory.getPerson_Male();
        Address address1 = ModelTestFactory.getAddress(person1);
        PersonAddress personAddress1 = new PersonAddress(person1, null, address1);

        Assertions.assertTrue(personAddress1.getPrimaryAddress().isEmpty());
        Assertions.assertTrue(personAddress1.getSecondaryAddress().isPresent());
    }

    @Test
    void toStringTest() {
        Person person1 = ModelTestFactory.getPerson_Male();
        Address address1 = ModelTestFactory.getAddress(person1);
        PersonAddress personAddress1 = new PersonAddress(person1, address1, null);
        String result = personAddress1.toString();

        Assertions.assertNotNull(result);
        Assertions.assertEquals("PersonAddress{person=Person{id=null, firstName='firstName', lastName='lastName', middleName='null', birthDt=2024-06-26, sexCode=SexCode{id='M', description='Male'}}, primaryAddress=Address{id=null, attention='firstName lastName', deliveryInfo='null', civicAddress='null', postalInfo='null', city='city', prov='pr', postal='postal', country='co', primary=true}, secondaryAddress=null}", result);
    }

}
