package ca.mikegabelmann.demo2.controller.rest;

import ca.mikegabelmann.demo2.dto.PersonAddressDto;
import ca.mikegabelmann.demo2.persistence.model.Address;
import ca.mikegabelmann.demo2.persistence.model.Person;
import ca.mikegabelmann.demo2.persistence.model.SexCode;
import ca.mikegabelmann.demo2.service.dto.PersonAddress;
import ca.mikegabelmann.demo2.service.facade.PersonFacade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;


@WebMvcTest(PersonAddressRestController.class)
public class PersonAddressRestControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private PersonFacade personFacade;

    private PersonAddress personAddress;


    @BeforeEach
    void beforeEach() {
        this.personAddress = new PersonAddress(new Person(), new Address(), new Address());
        personAddress.getPerson().setSexCode(new SexCode());
    }

    /*
    @Test
    @DisplayName("map record - null")
    void test1_map() {
        Assertions.assertNull(PersonAddressRestController.map((PersonAddress) null));
    }

    @Test
    @DisplayName("map list - null")
    void test2_map() {
        List<PersonAddressDto> results = PersonAddressRestController.map((List<PersonAddress>) null);
        Assertions.assertNotNull(results);
        Assertions.assertEquals(0, results.size());
    }

    @Test
    @DisplayName("map - value")
    void test3_map() {
        PersonAddressDto result = PersonAddressRestController.map(personAddress);

        Assertions.assertNotNull(result);
        Assertions.assertNotNull(result.getPerson());
        Assertions.assertNotNull(result.getPrimary());
        Assertions.assertNotNull(result.getSecondary());
    }

    @Test
    @DisplayName("map list - value")
    void test4_map() {
        List<PersonAddressDto> results = PersonAddressRestController.map(List.of(personAddress));

        Assertions.assertNotNull(results);
        Assertions.assertEquals(1, results.size());
    }
     */

    @Test
    @DisplayName("getPersonAddress - with results")
    void test1_getPersonAddress() throws Exception {
        Mockito.when(personFacade.getPersonAddress(1L)).thenReturn(Optional.of(personAddress));

        mvc.perform(
                get(PersonAddressRestController.PATH_GET_PERSONADDRESS, 1L))
                //.andDo(print())
                .andExpectAll(
                    status().isOk(),
                    content().string(startsWith("{\"person\":{\"id\":null,\"firstName\":null,\"lastName\":null,\"middleName\":null,\"birthDt\":null,\"sex\":null},\"primary\":{\"id\":null,\"attention\":null,\"streetAddress\":null,\"city\":null,\"prov\":null,\"country\":null,\"postal\":null},\"secondary\":{\"id\":null,\"attention\":null,\"streetAddress\":null,\"city\":null,\"prov\":null,\"country\":null,\"postal\":null}}"))
        );
    }

    @Test
    @DisplayName("getPersonAddress - without results")
    void test2_getPersonAddress() throws Exception {
        Mockito.when(personFacade.getPersonAddress(1L)).thenReturn(Optional.of(personAddress));

        mvc.perform(
                get(PersonAddressRestController.PATH_GET_PERSONADDRESS, 2L))
                //.andDo(print())
                .andExpect(
                    status().isNotFound()
                );
    }
}
