package ca.mikegabelmann.demo2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;


@AllArgsConstructor
@Data
public class AddressDto {
    private UUID id;
    private String attention;
    private String deliveryInfo;
    private String civicAddress;
    private String postalInfo;
    private String city;
    private String prov;
    private String postal;
    private String country;
    private Boolean primary;
}
