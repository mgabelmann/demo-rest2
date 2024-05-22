package ca.mikegabelmann.demo2.dto;


import lombok.Builder;
import lombok.Value;


@Builder
@Value
public class AddressDto {
    Long id;
    String attention;
    String deliveryInfo;
    String civicAddress;
    String postalInfo;
    String city;
    String prov;
    String postal;
    String country;
    Boolean primary;
}
