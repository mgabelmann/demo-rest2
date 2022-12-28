package ca.mikegabelmann.demo2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Demo2Application {
    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(Demo2Application.class);


    /**
     * Entry point to start application.
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        //change default application property name, useful for deploying to application container, instead of standalone
        System.setProperty("spring.config.name", "application");

        SpringApplication.run(Demo2Application.class, args);
    }

}
