package ca.mikegabelmann.demo2.service;

import ca.mikegabelmann.demo2.persistence.model.Person;

import java.time.LocalDate;
import java.util.List;


public interface PersonService {

    /**
     * Find people by sex and birth date.
     * @param sex sex
     * @param date birth date
     * @return records
     */
    List<Person> findBySexAndBirthDt(String sex, LocalDate date);

}
