package ca.mikegabelmann.demo2.search;

import ca.mikegabelmann.demo2.codes.Sex;
import lombok.Data;

import java.time.LocalDate;

/**
 * <p>NOTE: by creating a class to contain the search parameters, you don't have to refactor your endpoint or alter
 * any clients. Just update this class with the new property or properties, and you are done, except for your service.
 * </p>
 */
@Data
public class PersonSearch1 {
    Sex sex;
    LocalDate date;
}
