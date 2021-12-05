package ca.mikegabelmann.demo2.service;

import ca.mikegabelmann.demo2.persistence.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonServiceImpl implements PersonService {
    /** Logger. */
    private static final Logger LOG = LogManager.getLogger(PersonServiceImpl.class);

    private final PersonRepository personRepository;


    @Autowired
    public PersonServiceImpl(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

}
