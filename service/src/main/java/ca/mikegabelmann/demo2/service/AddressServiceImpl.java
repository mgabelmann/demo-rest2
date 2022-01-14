package ca.mikegabelmann.demo2.service;

import ca.mikegabelmann.demo2.dto.AddressDto;
import ca.mikegabelmann.demo2.persistence.model.Address;
import ca.mikegabelmann.demo2.persistence.repository.AddressRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AddressServiceImpl implements AddressService {
    /** Logger. */
    private static final Logger LOG = LogManager.getLogger(AddressServiceImpl.class);

    private final AddressRepository addressRepository;


    @Autowired
    public AddressServiceImpl(final AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<AddressDto> getAddressByCountryAndProvAndCity(String country, String prov, String city) {
        List<Address> results = addressRepository.getAddressByCountryAndProvAndCity(country, prov, city);

        return results.stream().map(AddressServiceImpl::map).collect(Collectors.toList());
    }

    /**
     * Convert Address to AddressDto.
     * @param a record
     * @return mapped record
     */
    public static AddressDto map(Address a) {
        AddressDto tmp;

        if (a != null) {
            tmp = new AddressDto(a.getId(), a.getAttention(), a.getStreetAddress(), a.getCity(), a.getProv(), a.getCountry(), a.getPostal());

        } else {
            tmp = null;
        }

        return tmp;
    }

}
