package ca.mikegabelmann.demo2.service;

import ca.mikegabelmann.demo2.persistence.repository.AddressRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressServiceImpl implements AddressService {
    /** Logger. */
    private static final Logger LOG = LogManager.getLogger(AddressServiceImpl.class);

    private final AddressRepository addressRepository;


    @Autowired
    public AddressServiceImpl(final AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

}
