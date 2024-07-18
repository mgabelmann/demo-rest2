package ca.mikegabelmann.demo2.persistence.service;

import ca.mikegabelmann.demo2.persistence.model.Address;

import java.util.List;


public interface AddressService {

    /**
     *
     * @param country
     * @param prov
     * @param city
     * @return
     */
    List<Address> getAddressByCountryAndProvAndCity(String country, String prov, String city);

}
