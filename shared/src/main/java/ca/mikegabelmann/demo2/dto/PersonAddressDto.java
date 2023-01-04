package ca.mikegabelmann.demo2.dto;

import lombok.Builder;
import lombok.Value;


@Builder
@Value
public class PersonAddressDto {
    private PersonDto person;
    private AddressDto primary;
    private AddressDto secondary;

}
