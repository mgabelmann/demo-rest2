package ca.mikegabelmann.demo2.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public final class HelloWorldRestController {
    /** Path for REST endpoint. */
    public static final String PATH_HELLOWORLD = "/helloworld";

    @GetMapping(path = HelloWorldRestController.PATH_HELLOWORLD)
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("hello world");
    }

}
