package ca.mikegabelmann.demo2.service.dto;

import ca.mikegabelmann.demo2.persistence.model.Address;
import ca.mikegabelmann.demo2.persistence.model.Person;

import java.util.Optional;


public class PersonAddress {
    private final Person person;
    private final Address primaryAddress;
    private final Address secondaryAddress;

    public PersonAddress(Person person, Address primaryAddress, Address secondaryAddress) {
        this.person = person;
        this.primaryAddress = primaryAddress;
        this.secondaryAddress = secondaryAddress;
    }

    public Person getPerson() {
        return person;
    }

    public Optional<Address> getPrimaryAddress() {
        return Optional.ofNullable(primaryAddress);
    }

    public Optional<Address> getSecondaryAddress() {
        return Optional.ofNullable(secondaryAddress);
    }

}
