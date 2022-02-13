package ca.mikegabelmann.demo2.service;

import ca.mikegabelmann.demo2.persistence.model.Address;
import ca.mikegabelmann.demo2.persistence.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class AddressServiceImpl implements AddressService {
    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(AddressServiceImpl.class);

    private final AddressRepository addressRepository;


    @Autowired
    public AddressServiceImpl(final AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Address> getAddressByCountryAndProvAndCity(String country, String prov, String city) {
        return addressRepository.getAddressByCountryAndProvAndCity(country, prov, city);
    }

}
