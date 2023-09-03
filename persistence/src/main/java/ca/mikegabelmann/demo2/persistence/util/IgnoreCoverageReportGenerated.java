package ca.mikegabelmann.demo2.persistence.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * This annotation is used so that Jacoco will ignore classes, methods, constructors in calculation of
 * test coverage. You can also use @Generated, essentially the annotation must include 'Generated' in
 * the name.
 */
@Documented
@Retention(RUNTIME)
@Target({TYPE, METHOD, CONSTRUCTOR})
public @interface IgnoreCoverageReportGenerated {
    /**
     * Include a reason why this should be excluded from test coverage.
     * @return reason
     */
    String reason() default "no testable code";
}
