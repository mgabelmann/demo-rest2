package ca.mikegabelmann.demo2.controller.config;

import ca.mikegabelmann.demo2.controller.rest.HelloWorldRestController;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * <p>This configuration allows CORS requests. If the header "Access-Control-Allow-Origin" exists then
 * requests from that URI are allowed, otherwise they are denied.</p>
 *
 * <p><b>Allowed</b></p>
 * <pre>
 * curl -X GET -H "Origin: http://localhost:8080" --head http://localhost:8080/helloworld
 * HTTP/1.1 200
 * Vary: Origin
 * Vary: Access-Control-Request-Method
 * Vary: Access-Control-Request-Headers
 * Access-Control-Allow-Origin: http://localhost:8080
 * Content-Type: text/plain;charset=UTF-8
 * Content-Length: 11
 * </pre>
 *
 * <p><b>Not Allowed</b></p>
 * <pre>
 * curl -X GET -H "Origin: http://www.apple.com" --head http://localhost:8080/helloworld
 * HTTP/1.1 403
 * Vary: Origin
 * Vary: Access-Control-Request-Method
 * Vary: Access-Control-Request-Headers
 * Transfer-Encoding: chunked
 * </pre>
 */
@Component
@Configurable
public class CorsConfig implements RepositoryRestConfigurer {
    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(CorsConfig.class);

    /** Enable or disable CORs filtering. */
    @Value("${app.cors.enabled:true}")
    private boolean corsEnabled;

    /** Application CORS URI with default value. */
    @Value("${app.cors.url:http://localhost:8080}")
    private String corsUrl;


    @Autowired
    public CorsConfig(ProfileType profileType) {
        LOG.info("profile bean loaded = {}", profileType.getProfile());
    }

    @PostConstruct
    private void postConstruct() {
        if (LOG.isInfoEnabled()) {
            LOG.info("CORS filtering={}, URI={}", corsEnabled, corsUrl);
        }
    }

    //NOTE: allows CORS requests for Spring Data REST.
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        if (corsEnabled) {
            cors.addMapping("/**")
                .allowedOrigins(corsUrl)
                .allowedMethods(
                    RequestMethod.GET.name(),
                    RequestMethod.PUT.name(),
                    RequestMethod.DELETE.name(),
                    RequestMethod.POST.name()
                )
            ;
        }
    }

    //NOTE: allows CORS requests for Spring REST Controllers.
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                if (corsEnabled) {
                    registry.addMapping(HelloWorldRestController.PATH_HELLOWORLD)
                        .allowedMethods(
                            RequestMethod.GET.name()
                        )
                        .allowedOrigins(corsUrl)
                    ;

                    registry.addMapping("/persons/**")
                            .allowedMethods(
                                RequestMethod.GET.name(),
                                RequestMethod.PUT.name(),
                                RequestMethod.DELETE.name(),
                                RequestMethod.POST.name()
                            )
                            .allowedOrigins(corsUrl)
                    ;
                }
            }
        };
    }

}
