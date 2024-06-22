package ca.mikegabelmann.demo2.search;

import ca.mikegabelmann.demo2.codes.Sex;
import lombok.Value;

import java.time.LocalDate;

/**
 * NOTE: by creating a class to contain the search parameters, you don't have to refactor your endpoint or alter
 * any clients. Just update this class with the new property, and you are done, except for your service.
 */
@Value
public class PersonSearch1 {
    Sex sex;
    LocalDate date;
}
