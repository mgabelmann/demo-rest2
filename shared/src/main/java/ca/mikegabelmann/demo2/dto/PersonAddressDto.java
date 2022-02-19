package ca.mikegabelmann.demo2.dto;


public class PersonAddressDto {
    private final PersonDto person;
    private final AddressDto primary;
    private final AddressDto secondary;


    public PersonAddressDto(PersonDto person) {
        this(person, null, null);
    }

    public PersonAddressDto(PersonDto person, AddressDto primary) {
        this(person, primary, null);
    }

    public PersonAddressDto(PersonDto person, AddressDto primary, AddressDto secondary) {
        if (person == null) throw new IllegalArgumentException("person required");

        this.person = person;
        this.primary = primary;
        this.secondary = secondary;
    }

    public PersonDto getPerson() {
        return person;
    }

    public AddressDto getPrimary() {
        return primary;
    }

    public AddressDto getSecondary() {
        return secondary;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PersonAddressDto{");
        sb.append("person=").append(person);
        sb.append(", primary=").append(primary);
        sb.append(", secondary=").append(secondary);
        sb.append('}');

        return sb.toString();
    }

}
