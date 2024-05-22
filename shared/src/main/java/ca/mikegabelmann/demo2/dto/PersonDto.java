package ca.mikegabelmann.demo2.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;


@Builder
@Value
public class PersonDto {
    Long id;
    String firstName;
    String lastName;
    String middleName;
    LocalDate birthDt;
    String sex;

}
