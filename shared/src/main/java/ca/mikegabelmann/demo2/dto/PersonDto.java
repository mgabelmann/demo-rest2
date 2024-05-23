package ca.mikegabelmann.demo2.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;


@Builder
@Value
public class PersonDto {
    UUID id;
    String firstName;
    String lastName;
    String middleName;
    LocalDate birthDt;
    String sex;

}
