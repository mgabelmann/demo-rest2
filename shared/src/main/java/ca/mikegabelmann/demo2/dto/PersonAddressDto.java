package ca.mikegabelmann.demo2.dto;

import lombok.Builder;
import lombok.Value;


@Builder
@Value
public class PersonAddressDto {
    PersonDto person;
    AddressDto primary;
    AddressDto secondary;

}
