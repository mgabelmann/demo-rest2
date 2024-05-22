package ca.mikegabelmann.demo2.persistence.service;

import ca.mikegabelmann.demo2.persistence.model.Person;
import ca.mikegabelmann.demo2.persistence.repository.PersonRepository;
import ca.mikegabelmann.demo2.persistence.util.IgnoreCoverageReportGenerated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {
    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(PersonServiceImpl.class);

    private final PersonRepository personRepository;


    @Autowired
    public PersonServiceImpl(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Person> findBySexAndBirthDt(final String sex, final LocalDate date) {
        LOG.debug("sex={}, date={}", sex, date);

        return personRepository.findBySexCodeIdAndBirthDt(sex, date);
    }

    @Transactional
    @Override
    @IgnoreCoverageReportGenerated
    public Person createOrUpdate(final Person p) {
        return personRepository.save(p);
    }

}
