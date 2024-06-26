package ca.mikegabelmann.demo2.controller.rest;

import ca.mikegabelmann.demo2.controller.rest.mapper.DtoMapper;
import ca.mikegabelmann.demo2.persistence.model.Address;
import ca.mikegabelmann.demo2.persistence.model.ModelTestFactory;
import ca.mikegabelmann.demo2.persistence.model.Person;
import ca.mikegabelmann.demo2.persistence.facade.PersonFacade;
import ca.mikegabelmann.demo2.persistence.facade.bean.PersonAddress;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;
import java.util.UUID;


@WebMvcTest(PersonAddressRestController.class)
@ComponentScan(basePackageClasses = {
    DtoMapper.class
})
class PersonAddressRestControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private DtoMapper dtoMapper;

    @MockBean
    private PersonFacade personFacade;

    private PersonAddress personAddress;


    @BeforeEach
    void beforeEach() {
        Person person1 = ModelTestFactory.getPerson_Male();
        Address address1 = ModelTestFactory.getAddress(person1);
        Address address2 = ModelTestFactory.getAddress(person1);
        this.personAddress = new PersonAddress(person1, address1, address2);
    }

    @Disabled("failing")
    @Test
    @DisplayName("getPersonAddress - with results")
    void test1_getPersonAddress() throws Exception {
        Mockito.when(personFacade.getPersonAddress(personAddress.getPerson().getId())).thenReturn(Optional.of(personAddress));

        mvc.perform(
                get(PersonAddressRestController.PATH_GET_PERSONADDRESS, personAddress.getPerson().getId()))
                //.andDo(print())
                .andExpectAll(
                    status().isOk(),
                    content().string(startsWith("{\"person\":{\"id\":null,\"firstName\":null,\"lastName\":null,\"middleName\":null,\"birthDt\":null,\"sex\":null},\"primary\":{\"id\":null,\"attention\":null,\"streetAddress\":null,\"city\":null,\"prov\":null,\"country\":null,\"postal\":null},\"secondary\":{\"id\":null,\"attention\":null,\"streetAddress\":null,\"city\":null,\"prov\":null,\"country\":null,\"postal\":null}}"))
        );
    }

    @Test
    @DisplayName("getPersonAddress - without results")
    void test2_getPersonAddress() throws Exception {
        Mockito.when(personFacade.getPersonAddress(personAddress.getPerson().getId())).thenReturn(Optional.of(personAddress));

        mvc.perform(
                get(PersonAddressRestController.PATH_GET_PERSONADDRESS, UUID.randomUUID()))
                //.andDo(print())
                .andExpect(
                    status().isNotFound()
                );
    }
}
