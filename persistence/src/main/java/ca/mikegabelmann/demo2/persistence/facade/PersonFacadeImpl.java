package ca.mikegabelmann.demo2.persistence.facade;

import ca.mikegabelmann.demo2.persistence.model.Address;
import ca.mikegabelmann.demo2.persistence.model.Person;
import ca.mikegabelmann.demo2.persistence.repository.AddressRepository;
import ca.mikegabelmann.demo2.persistence.repository.PersonRepository;
import ca.mikegabelmann.demo2.persistence.facade.dto.PersonAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonFacadeImpl implements PersonFacade {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;


    @Autowired
    public PersonFacadeImpl(final PersonRepository personRepository, final AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public Optional<PersonAddress> getPersonAddress(final Long id) {
        Optional<Person> record = personRepository.findById(id);

        if (record.isPresent()) {
            Person person = record.get();

            List<Address> records = person.getAddresses();
            Address primary = records.isEmpty() ? null : records.get(0);
            Address secondary = records.size() <= 1 ? null : records.get(1);

            return Optional.of(new PersonAddress(person, primary, secondary));

        } else {
            return Optional.empty();
        }
    }

}
