package ca.mikegabelmann.demo2.controller.rest;

import ca.mikegabelmann.demo2.persistence.model.ModelTestFactory;
import ca.mikegabelmann.demo2.persistence.model.Person;
import ca.mikegabelmann.demo2.persistence.model.SexCode;
import ca.mikegabelmann.demo2.persistence.repository.PersonRepository;
import ca.mikegabelmann.demo2.persistence.repository.SexCodeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * <p>This is an integration test. HTTP/REST calls are made to the controller and all other objects (service, repository,
 * and in-memory database) are used.</p>
 */
@SpringBootTest
@AutoConfigureMockMvc
//FIXME: for some reason I need to include this otherwise I get an error stating that the Repository beans are already registered.
@EnableJpaRepositories(basePackages = {
    "ca.mikegabelmann.demo2.persistence.repository"
})
class PersonRestControllerIT {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private SexCodeRepository sexCodeRepository;

    @Autowired
    private PersonRepository personRepository;

    private SexCode s;
    private Person p;
    private LocalDate now;


    @BeforeEach
    void beforeEach() {
        this.now = LocalDate.now();

        SexCode sTmp = ModelTestFactory.getSexCode_Female();
        this.s = sexCodeRepository.save(sTmp);

        Person pTmp = ModelTestFactory.getPerson(s);
        this.p = personRepository.save(pTmp);
    }

    @Test
    @DisplayName("findBySexAndBirthDt - Sex/LocalDate - with results")
    void test1_findBySexAndBirthDt() throws Exception {
        mvc.perform(
                get(PersonRestController.PATH_SEARCH1)
                        .param("sex", "F")
                        .param("date", now.toString())

                //).andDo(print()
        ).andExpectAll(
                status().isOk(),
                content().string(startsWith("[{\"id\":\"" + p.getId() + "\",\"firstName\":\"firstName\",\"lastName\":\"lastName\",\"middleName\":null,\"birthDt\":\"" + now.toString() + "\",\"sex\":\"F\"}]"))
        );
    }

    @Test
    @DisplayName("findBySexAndBirthDt - PersonSearch1 - with results")
    void test3_findBySexAndBirthDt() throws Exception {
        mvc.perform(
                get(PersonRestController.PATH_SEARCH1)
                        .param("sex", "F")
                        .param("date", now.toString())

                //).andDo(print()
        ).andExpectAll(
                status().isOk(),
                content().string(startsWith("[{\"id\":"))
        );
    }

}
