package ca.mikegabelmann.demo2.service;

import ca.mikegabelmann.demo2.persistence.model.Person;
import ca.mikegabelmann.demo2.persistence.repository.PersonRepository;
import ca.mikegabelmann.demo2.dto.PersonDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PersonServiceImpl implements PersonService {
    /** Logger. */
    private static final Logger LOG = LogManager.getLogger(PersonServiceImpl.class);

    private final PersonRepository personRepository;


    @Autowired
    public PersonServiceImpl(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<PersonDto> findBySexAndBirthDt(String sex, LocalDate date) {
        List<Person> records = personRepository.findBySexCodeIdAndBirthDt(sex, date);

        return records.stream().map(PersonServiceImpl::map).collect(Collectors.toList());
    }

    /**
     * Convert Person to PersonDto.
     * @param p record
     * @return mapped record
     */
    public static PersonDto map(Person p) {
        PersonDto tmp;

        if (p != null) {
            tmp = new PersonDto(p.getId(), p.getFirstName(), p.getLastName(), p.getMiddleName(), p.getBirthDt(), p.getSexCode().getId());

        } else {
            tmp = null;
        }

        return tmp;
    }

}
