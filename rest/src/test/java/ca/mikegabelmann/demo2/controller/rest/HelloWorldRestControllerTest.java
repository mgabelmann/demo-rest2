package ca.mikegabelmann.demo2.controller.rest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(HelloWorldRestController.class)
public class HelloWorldRestControllerTest {
    @Autowired
    private MockMvc mvc;


    @Test
    @DisplayName("helloWorld - with results")
    void test1_helloWorld() throws Exception {
        mvc.perform(
                get(HelloWorldRestController.PATH_HELLOWORLD)

                //).andDo(print()
        ).andExpectAll(
                status().isOk(),
                content().string(startsWith("hello world"))
        );
    }

}
