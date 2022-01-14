package ca.mikegabelmann.demo2.service;

import ca.mikegabelmann.demo2.codes.Sex;
import ca.mikegabelmann.demo2.dto.AddressDto;
import ca.mikegabelmann.demo2.dto.PersonDto;
import ca.mikegabelmann.demo2.persistence.model.Address;
import ca.mikegabelmann.demo2.persistence.model.Person;
import ca.mikegabelmann.demo2.persistence.model.SexCode;
import ca.mikegabelmann.demo2.persistence.repository.AddressRepository;
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
class AddressServiceImplTest {
    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressServiceImpl addressService;

    private Person p;
    private Address a;


    @BeforeEach
    void beforeEach() {
        SexCode sex = new SexCode(Sex.M.name(), Sex.M.toString());
        this.p = new Person(1L, "firstName", "lastName", LocalDate.now(), sex);
        this.a = new Address(1L, "streetAddress", "city", "prov", "country", "postal", p);
    }

    @Test
    @DisplayName("getAddressByCountryAndProvAndCity - with results")
    void test1_getAddressByCountryAndProvAndCity() {
        Mockito.when(addressRepository.getAddressByCountryAndProvAndCity("country", "prov", "city")).thenReturn(List.of(a));

        List<AddressDto> results = addressService.getAddressByCountryAndProvAndCity("country", "prov", "city");
        Assertions.assertNotNull(results);
        Assertions.assertEquals(1, results.size());
    }

    @Test
    @DisplayName("map - null")
    void test1_map() {
        Assertions.assertNull(AddressServiceImpl.map(null));
    }

    @Test
    @DisplayName("map - value")
    void test2_map() {
        AddressDto result = AddressServiceImpl.map(a);

        Assertions.assertNotNull(result);

        Assertions.assertEquals(a.getId(), result.getId());
        Assertions.assertEquals(a.getAttention(), result.getAttention());
        Assertions.assertEquals(a.getStreetAddress(), result.getStreetAddress());
        Assertions.assertEquals(a.getCity(), result.getCity());
        Assertions.assertEquals(a.getProv(), result.getProv());
        Assertions.assertEquals(a.getCountry(), result.getCountry());
        Assertions.assertEquals(a.getPostal(), result.getPostal());
    }

}