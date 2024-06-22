package ca.mikegabelmann.demo2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class PersonAddressDto {
    private PersonDto person;
    private AddressDto primary;
    private AddressDto secondary;
}
