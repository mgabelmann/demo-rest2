package ca.mikegabelmann.demo2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 * Overrides 'spring.config.name' so multiple applications deployed to an application container will not conflict.
 * @author mgabelmann
 */
@SpringBootApplication
public class ServletInitializer extends SpringBootServletInitializer {
    /** Logger. */
    private static final Logger LOG = LogManager.getLogger(ServletInitializer.class);

    /**
     * Application name. Must be unique if multiple apps deployed to same application server.
     *
     * <pre>
     * application-APPNAME.properties
     * application-APPNAME-ENV.properties
     * </pre>
     */
    public static final String APPLICATION_PROPERTIES = "application-demorest";


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        if (LOG.isInfoEnabled()) {
            LOG.info("NOTE: loading configuration with name prefix - {}", APPLICATION_PROPERTIES);
        }

        return application
            .properties("spring.config.name:" + APPLICATION_PROPERTIES)
            .sources(Demo2Application.class);
    }

}
