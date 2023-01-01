package ca.mikegabelmann.demo2.persistence.model;

import java.time.LocalDate;

/**
 * Used to construct Model/JPA objects with 'sane' defaults.
 */
public class ModelTestFactory {
    /** Do not instantiate this class. */
    private ModelTestFactory() {}

    public static SexCode getSexCode_Male() {
        return new SexCode("M", "Male");
    }

    public static SexCode getSexCode_Female() {
        return new SexCode("F", "Female");
    }

    public static Person getPerson(final SexCode sexCode) {
        return new Person(null, "firstName", "lastName", LocalDate.now(), sexCode);
    }

    public static Person getPerson_Male() {
        return getPerson(getSexCode_Male());
    }

    public static Person getPerson_Female() {
        return getPerson(getSexCode_Female());
    }

    public static Address getAddress(final Person person) {
        return new Address(null, "streetAddress", "city", "prov", "country", "postal", person);
    }

}
