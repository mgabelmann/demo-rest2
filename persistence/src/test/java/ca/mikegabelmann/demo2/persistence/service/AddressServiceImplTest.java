package ca.mikegabelmann.demo2.persistence.service;

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
        SexCode sex = new SexCode("M", "Male");
        this.p = new Person(1L, "firstName", "lastName", LocalDate.now(), sex);
        this.a = new Address(1L, "streetAddress", "city", "prov", "country", "postal", p);
    }

    @Test
    @DisplayName("getAddressByCountryAndProvAndCity - with results")
    void test1_getAddressByCountryAndProvAndCity() {
        Mockito.when(addressRepository.getAddressByCountryAndProvAndCity("country", "prov", "city")).thenReturn(List.of(a));

        List<Address> results = addressService.getAddressByCountryAndProvAndCity("country", "prov", "city");
        Assertions.assertNotNull(results);
        Assertions.assertEquals(1, results.size());
    }

}