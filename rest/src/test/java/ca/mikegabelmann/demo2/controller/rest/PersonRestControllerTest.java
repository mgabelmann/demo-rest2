package ca.mikegabelmann.demo2.controller.rest;

import ca.mikegabelmann.demo2.codes.Sex;
import ca.mikegabelmann.demo2.controller.rest.mapper.DtoMapper;
import ca.mikegabelmann.demo2.persistence.model.ModelTestFactory;
import ca.mikegabelmann.demo2.persistence.model.Person;
import ca.mikegabelmann.demo2.persistence.model.SexCode;
import ca.mikegabelmann.demo2.persistence.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(PersonRestController.class)
@ComponentScan(basePackageClasses = {
    DtoMapper.class
})
class PersonRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private DtoMapper dtoMapper;

    @MockBean
    private PersonService personService;

    private Person person;


    @BeforeEach
    void beforeEach() {
        SexCode sexCode = ModelTestFactory.getSexCode_Male();
        this.person = new Person(UUID.randomUUID(), "firstName", "lastName", LocalDate.of(2000, 1, 15), sexCode);
    }

    @Test
    @DisplayName("findBySexAndBirthDt - Sex/LocalDate - with results")
    void test1_findBySexAndBirthDt() throws Exception {
        Mockito.when(personService.findBySexAndBirthDt(Sex.M.name(), person.getBirthDt())).thenReturn(List.of(person));

        mvc.perform(
                get(PersonRestController.PATH_SEARCH1)
                    .param("sex", "M")
                    .param("date", "2000-01-15")

        //).andDo(print()
        ).andExpectAll(
                status().isOk(),
                content().string(startsWith("[{\"id\":\"" + person.getId() + "\",\"firstName\":\"firstName\",\"lastName\":\"lastName\",\"middleName\":null,\"birthDt\":\"2000-01-15\",\"sex\":\"M\"}]"))
        );
    }

    @Test
    @DisplayName("findBySexAndBirthDt - Sex/LocalDate - without results")
    void test2_findBySexAndBirthDt() throws Exception {
        mvc.perform(
                get(PersonRestController.PATH_SEARCH1)
                        .param("sex", "M")
                        .param("date", "2000-01-15")

        //).andDo(print()
        ).andExpectAll(
                status().isOk(),
                content().string(startsWith("[]"))
        );
    }

    @Test
    @DisplayName("findBySexAndBirthDt - PersonSearch1 - with results")
    void test3_findBySexAndBirthDt() throws Exception {
        Mockito.when(personService.findBySexAndBirthDt(Sex.M.name(), person.getBirthDt())).thenReturn(List.of(person));

        mvc.perform(
                get(PersonRestController.PATH_SEARCH1)
                        .param("sex", "M")
                        .param("date", "2000-01-15")

        //).andDo(print()
        ).andExpectAll(
                status().isOk(),
                content().string(startsWith("[{\"id\":\"" + person.getId() + "\",\"firstName\":\"firstName\",\"lastName\":\"lastName\",\"middleName\":null,\"birthDt\":\"2000-01-15\",\"sex\":\"M\"}]"))
        );
    }

    @Test
    @DisplayName("findBySexAndBirthDt - PersonSearch1 - without results")
    void test4_findBySexAndBirthDt() throws Exception {
        mvc.perform(
                get(PersonRestController.PATH_SEARCH1)
                        .param("sex", "M")
                        .param("date", "2000-01-15")

        //).andDo(print()
        ).andExpectAll(
                status().isOk(),
                content().string(startsWith("[]"))
        );
    }

}