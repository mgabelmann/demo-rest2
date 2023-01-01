package ca.mikegabelmann.demo2.persistence.service;

import ca.mikegabelmann.demo2.persistence.model.Address;
import ca.mikegabelmann.demo2.persistence.model.ModelTestFactory;
import ca.mikegabelmann.demo2.persistence.model.Person;
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
        this.p = ModelTestFactory.getPerson_Male();
        this.a = ModelTestFactory.getAddress(p);
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