package ca.mikegabelmann.demo2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;


@AllArgsConstructor
@Data
public class PersonDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthDt;
    private String sex;
}
