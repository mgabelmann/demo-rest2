package ca.mikegabelmann.demo2.controller.rest.mapper;

import ca.mikegabelmann.demo2.dto.PersonDto;
import ca.mikegabelmann.demo2.persistence.model.Person;
import ca.mikegabelmann.demo2.persistence.model.SexCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


/**
 * Unit tests for bean mapping.
 */
class DtoMapperTest {
    private final DtoMapper mapper = new DtoMapperImpl();

    private Person person1;
    private PersonDto personDto1;


    @BeforeEach
    void setUp() {
        this.person1 = new Person(1L, "firstName", "lastName", LocalDate.now(), new SexCode("M", "Male"));
        this.personDto1 = new PersonDto(1L, "firstName", "lastName", "middleName", LocalDate.now(), "M");
    }

    @Test
    @DisplayName("Person > PersonDto - null")
    void test1_mapPersonDto() {
        PersonDto result = mapper.mapPersonDto(null);
        Assertions.assertNull(result);
    }

    @Test
    @DisplayName("Person > PersonDto - not null")
    void test2_mapPersonDto() {
        PersonDto result = mapper.mapPersonDto(person1);
        Assertions.assertNotNull(result);

        Assertions.assertEquals(person1.getId(), result.getId());
        Assertions.assertEquals(person1.getFirstName(), result.getFirstName());
        Assertions.assertEquals(person1.getLastName(), result.getLastName());
        Assertions.assertEquals(person1.getMiddleName(), result.getMiddleName());
        Assertions.assertEquals(person1.getBirthDt(), result.getBirthDt());
        Assertions.assertEquals(person1.getSexCode().getId(), result.getSex());
    }

    @Test
    @DisplayName("PersonDto > Person - null")
    void test1_mapPerson() {
        Person result = mapper.mapPerson(null);
        Assertions.assertNull(result);
    }

    @Test
    @DisplayName("PersonDto > Person - not null")
    void test2_mapPerson() {
        Person result = mapper.mapPerson(personDto1);
        Assertions.assertNotNull(result);

        Assertions.assertEquals(personDto1.getId(), result.getId());
        Assertions.assertEquals(personDto1.getFirstName(), result.getFirstName());
        Assertions.assertEquals(personDto1.getLastName(), result.getLastName());
        Assertions.assertEquals(personDto1.getMiddleName(), result.getMiddleName());
        Assertions.assertEquals(personDto1.getBirthDt(), result.getBirthDt());
        Assertions.assertEquals(personDto1.getSex(), result.getSexCode().getId());
    }

    @Test
    @DisplayName("List Person > PersonDto - null")
    void test1_mapListPersonDto() {

    }

    @Test
    @DisplayName("List Person > PersonDto - not null")
    void test2_mapListPersonDto() {

    }

    @Test
    @DisplayName("List PersonDto > Person - null")
    void test1_mapListPerson() {
    }

    @Test
    @DisplayName("List PersonDto > Person - null")
    void test2_mapListPerson() {
    }

    @Test
    @DisplayName("List Address > AddressDto - null")
    void test1_mapAddressDto() {
    }

    @Test
    @DisplayName("List Address > AddressDto - not null")
    void test2_mapAddressDto() {
    }

    @Test
    @DisplayName("AddressDto > Address - null")
    void test1_mapAddress() {
    }

    @Test
    @DisplayName("AddressDto > Address - not null")
    void test2_mapAddress() {
    }

    @Test
    @DisplayName("List Address > AddressDto - null")
    void test1_mapListAddressDto() {
    }

    @Test
    @DisplayName("List Address > AddressDto - not null")
    void test2_mapListAddressDto() {
    }

    @Test
    @DisplayName("List AddressDto > Address - null")
    void test1_mapListAddress() {
    }

    @Test
    @DisplayName("List AddressDto > Address - not null")
    void test2_mapListAddress() {
    }

    @Test
    @DisplayName("PersonAddress > PersonAddressDto - null")
    void test1_mapPersonAddressDto() {
    }

    @Test
    @DisplayName("PersonAddress > PersonAddressDto - not null")
    void test2_mapPersonAddressDto() {
    }

    @Test
    @DisplayName("PersonAddressDto > PersonAddress - null")
    void test1_mapPersonAddress() {
    }

    @Test
    @DisplayName("PersonAddressDto > PersonAddress - not null")
    void test2_mapPersonAddress() {
    }

    @Test
    @DisplayName("List PersonAdressDto > PersonAddress - null")
    void test1_mapListPersonAddress() {
    }

    @Test
    @DisplayName("List PersonAdressDto > PersonAddress - not null")
    void test2_mapListPersonAddress() {
    }

    @Test
    @DisplayName("List PersonAddress > PersonAddressDto - null")
    void test1_mapListPersonAddressDto() {
    }

    @Test
    @DisplayName("List PersonAddress > PersonAddressDto - not null")
    void test2_mapListPersonAddressDto() {
    }

}