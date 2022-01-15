package ca.mikegabelmann.demo2.controller.rest;

import ca.mikegabelmann.demo2.dto.PersonDto;
import ca.mikegabelmann.demo2.codes.Sex;
import ca.mikegabelmann.demo2.persistence.model.Person;
import ca.mikegabelmann.demo2.persistence.model.SexCode;
import ca.mikegabelmann.demo2.service.PersonService;
import org.junit.jupiter.api.Assertions;
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

    private Person person;


    @BeforeEach
    void beforeEach() {
        SexCode sexCode = new SexCode(Sex.M.name(), Sex.M.toString());
        this.person = new Person(1L, "firstName", "lastName", LocalDate.of(2000, 1, 15), sexCode);
    }

    @Test
    @DisplayName("map record - null")
    void test1_map() {
        Assertions.assertNull(PersonRestController.map((Person) null));
    }

    @Test
    @DisplayName("map list - null")
    void test2_map() {
        Assertions.assertNull(PersonRestController.map((List<Person>) null));
    }

    @Test
    @DisplayName("map - value")
    void test3_map() {
        PersonDto result = PersonRestController.map(person);

        Assertions.assertNotNull(result);

        Assertions.assertEquals(person.getId(), result.getId());
        Assertions.assertEquals(person.getFirstName(), result.getFirstName());
        Assertions.assertEquals(person.getLastName(), result.getLastName());
        Assertions.assertEquals(person.getMiddleName(), result.getMiddleName());
        Assertions.assertEquals(person.getBirthDt(), result.getBirthDt());
        Assertions.assertEquals(person.getSexCode().getId(), result.getSex());
    }


    @Test
    @DisplayName("findBySexAndBirthDt - Sex/LocalDate - with results")
    void test1_findBySexAndBirthDt() throws Exception {
        Mockito.when(personService.findBySexAndBirthDt(Sex.M.name(), person.getBirthDt())).thenReturn(List.of(person));

        mvc.perform(
                get(PersonRestController.PATH_PERSONS_SEARCH)
                    .param("sex", "M")
                    .param("date", "2000-01-15")

        //).andDo(print()
        ).andExpectAll(
                status().isOk(),
                content().string(startsWith("[{\"id\":1,\"firstName\":\"firstName\",\"lastName\":\"lastName\",\"middleName\":null,\"birthDt\":\"2000-01-15\",\"sex\":\"M\"}]"))
        );
    }

    @Test
    @DisplayName("findBySexAndBirthDt - Sex/LocalDate - without results")
    void test2_findBySexAndBirthDt() throws Exception {
        mvc.perform(
                get(PersonRestController.PATH_PERSONS_SEARCH)
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
                get(PersonRestController.PATH_PERSONS_SEARCH1)
                        .param("sex", "M")
                        .param("date", "2000-01-15")

        //).andDo(print()
        ).andExpectAll(
                status().isOk(),
                content().string(startsWith("[{\"id\":1,\"firstName\":\"firstName\",\"lastName\":\"lastName\",\"middleName\":null,\"birthDt\":\"2000-01-15\",\"sex\":\"M\"}]"))
        );
    }

    @Test
    @DisplayName("findBySexAndBirthDt - PersonSearch1 - without results")
    void test4_findBySexAndBirthDt() throws Exception {
        mvc.perform(
                get(PersonRestController.PATH_PERSONS_SEARCH1)
                        .param("sex", "M")
                        .param("date", "2000-01-15")

        //).andDo(print()
        ).andExpectAll(
                status().isOk(),
                content().string(startsWith("[]"))
        );
    }

}