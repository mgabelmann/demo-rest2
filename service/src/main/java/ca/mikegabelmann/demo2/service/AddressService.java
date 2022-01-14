package ca.mikegabelmann.demo2.service;


import ca.mikegabelmann.demo2.dto.AddressDto;

import java.util.List;


public interface AddressService {

    List<AddressDto> getAddressByCountryAndProvAndCity(String country, String prov, String city);

}
