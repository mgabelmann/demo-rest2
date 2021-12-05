package ca.mikegabelmann.demo2.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorld {

    @GetMapping(path = "/helloworld")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("hello world");
    }

}
