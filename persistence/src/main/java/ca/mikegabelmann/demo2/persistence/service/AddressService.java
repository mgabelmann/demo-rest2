package ca.mikegabelmann.demo2.persistence.service;

import ca.mikegabelmann.demo2.persistence.model.Address;

import java.util.List;


public interface AddressService {

    List<Address> getAddressByCountryAndProvAndCity(String country, String prov, String city);

}
