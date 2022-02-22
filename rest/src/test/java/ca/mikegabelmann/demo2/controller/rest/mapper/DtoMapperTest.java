package ca.mikegabelmann.demo2.controller.rest.mapper;

import ca.mikegabelmann.demo2.dto.AddressDto;
import ca.mikegabelmann.demo2.dto.PersonDto;
import ca.mikegabelmann.demo2.persistence.model.Address;
import ca.mikegabelmann.demo2.persistence.model.Person;
import ca.mikegabelmann.demo2.persistence.model.SexCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.util.List;


/**
 * Unit tests for bean mapping.
 */
class DtoMapperTest {

    private final DtoMapper mapper = new DtoMapperImpl();

    private Person person1;
    private PersonDto personDto1;
    private Address address1;
    private AddressDto addressDto1;


    @BeforeEach
    void setUp() {
        this.person1 = new Person(1L, "firstName", "lastName", LocalDate.now(), new SexCode("M", "Male"));
        this.personDto1 = new PersonDto(1L, "firstName", "lastName", "middleName", LocalDate.now(), "M");
        this.address1 = new Address(1L, "streetAddress", "city", "prov", "country", "postal", person1);
        this.addressDto1 = new AddressDto(1L, "attention", "streetAddress", "city", "prov", "country", "postal");
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
        this.validate(person1, result);
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
        this.validate(personDto1, result);
    }

    @Test
    @DisplayName("List Person > PersonDto - null")
    void test1_mapListPersonDto() {
        List<PersonDto> results = mapper.mapListPersonDto(null);

        Assertions.assertNull(results);
    }

    @Test
    @DisplayName("List Person > PersonDto - not null")
    void test2_mapListPersonDto() {
        List<PersonDto> results = mapper.mapListPersonDto(List.of(person1));

        Assertions.assertNotNull(results);
        Assertions.assertEquals(1, results.size());
        this.validate(person1, results.get(0));
    }

    @Test
    @DisplayName("List PersonDto > Person - null")
    void test1_mapListPerson() {
        List<Person> results = mapper.mapListPerson(null);

        Assertions.assertNull(results);
    }

    @Test
    @DisplayName("List PersonDto > Person - null")
    void test2_mapListPerson() {
        List<Person> results = mapper.mapListPerson(List.of(personDto1));

        Assertions.assertNotNull(results);
        Assertions.assertEquals(1, results.size());
        this.validate(personDto1, results.get(0));
    }

    @Test
    @DisplayName("List Address > AddressDto - null")
    void test1_mapAddressDto() {
        List<Address> results = mapper.mapListAddress(null);

        Assertions.assertNull(results);
    }

    @Test
    @DisplayName("List Address > AddressDto - not null")
    void test2_mapAddressDto() {
        List<Address> results = mapper.mapListAddress(List.of(addressDto1));

        Assertions.assertNotNull(results);
        Assertions.assertEquals(1, results.size());
        this.validate(addressDto1, results.get(0));
    }

    @Test
    @DisplayName("AddressDto > Address - null")
    void test1_mapAddress() {
        Address result = mapper.mapAddress(null);

        Assertions.assertNull(result);
    }

    @Test
    @DisplayName("AddressDto > Address - not null")
    void test2_mapAddress() {
        Address result = mapper.mapAddress(addressDto1);

        Assertions.assertNotNull(result);
        this.validate(addressDto1, result);
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



    public void validate(Person expected, PersonDto result) {
        Assertions.assertEquals(expected.getId(), result.getId());
        Assertions.assertEquals(expected.getFirstName(), result.getFirstName());
        Assertions.assertEquals(expected.getLastName(), result.getLastName());
        Assertions.assertEquals(expected.getMiddleName(), result.getMiddleName());
        Assertions.assertEquals(expected.getBirthDt(), result.getBirthDt());
        Assertions.assertEquals(expected.getSexCode().getId(), result.getSex());
    }

    public void validate(PersonDto expected, Person result) {
        Assertions.assertEquals(expected.getId(), result.getId());
        Assertions.assertEquals(expected.getFirstName(), result.getFirstName());
        Assertions.assertEquals(expected.getLastName(), result.getLastName());
        Assertions.assertEquals(expected.getMiddleName(), result.getMiddleName());
        Assertions.assertEquals(expected.getBirthDt(), result.getBirthDt());
        Assertions.assertEquals(expected.getSex(), result.getSexCode().getId());
    }

    public void validate(Address expected, AddressDto result) {
        Assertions.assertEquals(expected.getId(), result.getId());
        Assertions.assertEquals(expected.getAttention(), result.getAttention());
        Assertions.assertEquals(expected.getStreetAddress(), result.getStreetAddress());
        Assertions.assertEquals(expected.getCity(), result.getCity());
        Assertions.assertEquals(expected.getProv(), result.getProv());
        Assertions.assertEquals(expected.getCountry(), result.getCountry());
        Assertions.assertEquals(expected.getPostal(), result.getPostal());
    }

    public void validate(AddressDto expected, Address result) {
        Assertions.assertEquals(expected.getId(), result.getId());
        Assertions.assertEquals(expected.getAttention(), result.getAttention());
        Assertions.assertEquals(expected.getStreetAddress(), result.getStreetAddress());
        Assertions.assertEquals(expected.getCity(), result.getCity());
        Assertions.assertEquals(expected.getProv(), result.getProv());
        Assertions.assertEquals(expected.getCountry(), result.getCountry());
        Assertions.assertEquals(expected.getPostal(), result.getPostal());
    }

}