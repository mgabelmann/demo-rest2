package ca.mikegabelmann.demo2.controller.config;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


/**
 * Example of how to use a spring Profile to construct different beans.
 */
@Profile("!local")
@Configuration
public class OtherEnvironmentConfig {
    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(OtherEnvironmentConfig.class);


    @PostConstruct
    public void postConstruct() {
        LOG.info("This config is only loaded if spring.profiles.active != local");
    }

    //TODO: add specialized beans here

    @Bean
    public ProfileType getProfileType() {
        return new ProfileType("NOT_LOCAL");
    }

}
