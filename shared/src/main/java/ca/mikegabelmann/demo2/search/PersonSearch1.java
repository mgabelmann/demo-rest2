package ca.mikegabelmann.demo2.search;

import ca.mikegabelmann.demo2.codes.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * NOTE: by creating a class to contain the search parameters, you don't have to refactor your endpoint or alter
 * any clients. Just update this class with the new property, and you are done, except for your service.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonSearch1 {
    private Sex sex;
    private LocalDate date;

}
