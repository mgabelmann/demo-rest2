package ca.mikegabelmann.demo2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@SpringBootApplication
public class Demo2Application {
    /** Logger. */
    private static final Logger LOG = LogManager.getLogger(Demo2Application.class);


    /**
     * Entry point to start application.
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(Demo2Application.class, args);
    }

}
