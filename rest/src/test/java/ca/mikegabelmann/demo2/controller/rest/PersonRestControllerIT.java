package ca.mikegabelmann.demo2.controller.rest;

import ca.mikegabelmann.demo2.persistence.model.Person;
import ca.mikegabelmann.demo2.persistence.model.Sex;
import ca.mikegabelmann.demo2.persistence.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class PersonRestControllerIT {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private PersonRepository personRepository;

    private Person p;
    private LocalDate now;


    @BeforeEach
    void beforeEach() {
        this.now = LocalDate.now();

        Person tmp = new Person(null, "firstName", "lastName", now, Sex.FEMALE);
        this.p = personRepository.save(tmp);
    }

    @Test
    @DisplayName("findBySexAndBirthDt - Sex/LocalDate - with results")
    void test1_findBySexAndBirthDt() throws Exception {
        mvc.perform(
                get("/persons/search")
                        .param("sex", "FEMALE")
                        .param("date", now.toString())

                //).andDo(print()
        ).andExpectAll(
                status().isOk(),
                content().string(startsWith("[{\"id\":" + p.getId() + ",\"firstName\":\"firstName\",\"lastName\":\"lastName\",\"middleName\":null,\"birthDt\":\"" + now.toString() + "\",\"sex\":\"FEMALE\"}]"))
        );
    }

    @Test
    @DisplayName("findBySexAndBirthDt - PersonSearch1 - with results")
    void test3_findBySexAndBirthDt() throws Exception {
        mvc.perform(
                get("/persons/search1")
                        .param("sex", "FEMALE")
                        .param("date", now.toString())

                //).andDo(print()
        ).andExpectAll(
                status().isOk(),
                content().string(startsWith("[{\"id\":"))
        );
    }

}