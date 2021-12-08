package ca.mikegabelmann.demo2.controller.rest;


import ca.mikegabelmann.demo2.dto.PersonDto;
import ca.mikegabelmann.demo2.persistence.model.Sex;
import ca.mikegabelmann.demo2.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(PersonRestController.class)
class PersonRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PersonService personService;

    private PersonDto personDto;


    @BeforeEach
    void beforeEach() {
        this.personDto = new PersonDto(1L, "lastName", "firstName", "middleName", LocalDate.of(2000, 1, 15), Sex.MALE.name());
    }

    @Test
    @DisplayName("findBySexAndBirthDt - Sex/LocalDate - with results")
    void test1_findBySexAndBirthDt() throws Exception {
        Mockito.when(personService.findBySexAndBirthDt(Sex.MALE, personDto.getBirthDt())).thenReturn(List.of(personDto));

        mvc.perform(
                get("/persons/search")
                    .param("sex", "MALE")
                    .param("date", "2000-01-15")

        //).andDo(print()
        ).andExpectAll(
                status().isOk(),
                content().string(startsWith("[{\"id\":1,\"firstName\":\"lastName\",\"lastName\":\"firstName\",\"middleName\":\"middleName\",\"birthDt\":\"2000-01-15\",\"sex\":\"MALE\"}]"))
        );
    }

    @Test
    @DisplayName("findBySexAndBirthDt - Sex/LocalDate - without results")
    void test2_findBySexAndBirthDt() throws Exception {
        mvc.perform(
                get("/persons/search")
                        .param("sex", "MALE")
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
        Mockito.when(personService.findBySexAndBirthDt(Sex.MALE, personDto.getBirthDt())).thenReturn(List.of(personDto));

        mvc.perform(
                get("/persons/search1")
                        .param("sex", "MALE")
                        .param("date", "2000-01-15")

        //).andDo(print()
        ).andExpectAll(
                status().isOk(),
                content().string(startsWith("[{\"id\":1,\"firstName\":\"lastName\",\"lastName\":\"firstName\",\"middleName\":\"middleName\",\"birthDt\":\"2000-01-15\",\"sex\":\"MALE\"}]"))
        );
    }

    @Test
    @DisplayName("findBySexAndBirthDt - PersonSearch1 - without results")
    void test4_findBySexAndBirthDt() throws Exception {
        mvc.perform(
                get("/persons/search1")
                        .param("sex", "MALE")
                        .param("date", "2000-01-15")

        //).andDo(print()
        ).andExpectAll(
                status().isOk(),
                content().string(startsWith("[]"))
        );
    }
}