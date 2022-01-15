package ca.mikegabelmann.demo2.controller.rest;

import ca.mikegabelmann.demo2.dto.AddressDto;
import ca.mikegabelmann.demo2.persistence.model.Address;
import ca.mikegabelmann.demo2.persistence.model.Person;
import ca.mikegabelmann.demo2.service.AddressService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;


@WebMvcTest(AddressRestController.class)
public class AddressRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AddressService addressService;

    private Address address;


    @BeforeEach
    void beforeEach() {
        this.address = new Address(1L, "streetAddress", "city", "prov", "country", "postal", new Person());
    }

    @Test
    @DisplayName("map record - null")
    void test1_map() {
        Assertions.assertNull(AddressRestController.map((Address) null));
    }

    @Test
    @DisplayName("map list - null")
    void test2_map() {
        Assertions.assertNull(AddressRestController.map((List<Address>) null));
    }

    @Test
    @DisplayName("map - value")
    void test3_map() {
        AddressDto result = AddressRestController.map(address);

        Assertions.assertNotNull(result);

        Assertions.assertEquals(address.getId(), result.getId());
        Assertions.assertEquals(address.getAttention(), result.getAttention());
        Assertions.assertEquals(address.getStreetAddress(), result.getStreetAddress());
        Assertions.assertEquals(address.getCity(), result.getCity());
        Assertions.assertEquals(address.getProv(), result.getProv());
        Assertions.assertEquals(address.getCountry(), result.getCountry());
        Assertions.assertEquals(address.getPostal(), result.getPostal());
    }

}