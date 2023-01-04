package ca.mikegabelmann.demo2.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;


@Builder
@Value
public class PersonDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthDt;
    private String sex;

}
