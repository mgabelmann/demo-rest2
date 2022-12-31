package ca.mikegabelmann.demo2.persistence.facade.dto;

import ca.mikegabelmann.demo2.persistence.model.Address;
import ca.mikegabelmann.demo2.persistence.model.Person;
import org.springframework.lang.Nullable;

import java.util.Optional;


public class PersonAddress {
    private final Person person;

    @Nullable
    private final Address primaryAddress;

    @Nullable
    private final Address secondaryAddress;


    public PersonAddress(final Person person) {
        this(person, null, null);
    }

    public PersonAddress(final Person person, final Address primaryAddress, final Address secondaryAddress) {
        if (person == null) {
            throw new IllegalArgumentException("person is required");
        }

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
