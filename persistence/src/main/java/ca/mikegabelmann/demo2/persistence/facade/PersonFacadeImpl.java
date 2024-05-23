package ca.mikegabelmann.demo2.persistence.facade;

import ca.mikegabelmann.demo2.persistence.model.Address;
import ca.mikegabelmann.demo2.persistence.model.Person;
import ca.mikegabelmann.demo2.persistence.repository.AddressRepository;
import ca.mikegabelmann.demo2.persistence.repository.PersonRepository;
import ca.mikegabelmann.demo2.persistence.facade.bean.PersonAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


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
    public Optional<PersonAddress> getPersonAddress(final UUID id) {
        Optional<Person> record = personRepository.findById(id);

        if (record.isPresent()) {
            Person person = record.get();
            List<Address> records = person.getAddresses();

            Address primary = records.stream().filter(Address::isPrimary).findFirst().orElse(null);
            Address secondary = records.stream().filter(a -> !a.isPrimary()).findFirst().orElse(null);

            return Optional.of(new PersonAddress(person, primary, secondary));

        } else {
            return Optional.empty();
        }
    }

}
