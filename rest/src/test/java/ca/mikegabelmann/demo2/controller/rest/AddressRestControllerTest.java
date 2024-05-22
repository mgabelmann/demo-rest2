package ca.mikegabelmann.demo2.controller.rest;

import ca.mikegabelmann.demo2.controller.rest.mapper.DtoMapper;
import ca.mikegabelmann.demo2.persistence.model.Address;
import ca.mikegabelmann.demo2.persistence.model.ModelTestFactory;
import ca.mikegabelmann.demo2.persistence.model.Person;
import ca.mikegabelmann.demo2.persistence.service.AddressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * We mock the service layer since we don't care about how it works, we are just testing the operations and responses
 * from the service. This is a unit test not an integration test!
 */
@WebMvcTest(AddressRestController.class)
@ComponentScan(basePackageClasses = {
    DtoMapper.class
})
class AddressRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private DtoMapper dtoMapper;

    @MockBean
    private AddressService addressService;

    private Address address;


    @BeforeEach
    void beforeEach() {
        Person person1 = ModelTestFactory.getPerson_Male();
        this.address = ModelTestFactory.getAddress(person1);
        this.address.setId(1L);
    }

    @Test
    @DisplayName("getAddressByCountryAndProvAndCity - with results")
    void test1_getAddressByCountryAndProvAndCity() throws Exception {
        Mockito.when(addressService.getAddressByCountryAndProvAndCity("co", "pr", "city")).thenReturn(List.of(address));

        mvc.perform(
                get(AddressRestController.PATH_ADDRESS_SEARCH1)
                        .param("country", "co")
                        .param("prov", "pr")
                        .param("city", "city")

                //).andDo(print()
        ).andExpectAll(
                status().isOk(),
                content().string(startsWith("[{\"id\":1,\"attention\":\"firstName lastName\",\"deliveryInfo\":null,\"civicAddress\":null,\"postalInfo\":null,\"city\":\"city\",\"prov\":\"pr\",\"postal\":\"postal\",\"country\":\"co\",\"primary\":true}]"))
        );
    }

}
