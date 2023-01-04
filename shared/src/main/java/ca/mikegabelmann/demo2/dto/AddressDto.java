package ca.mikegabelmann.demo2.dto;


import lombok.Builder;
import lombok.Value;


@Builder
@Value
public class AddressDto {
    private Long id;
    private String attention;
    private String streetAddress;
    private String city;
    private String prov;
    private String country;
    private String postal;

}
