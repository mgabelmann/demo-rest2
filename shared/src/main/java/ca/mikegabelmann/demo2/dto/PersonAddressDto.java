package ca.mikegabelmann.demo2.dto;


public class PersonAddressDto {
    private PersonDto person;
    private AddressDto primary;
    private AddressDto secondary;


    public PersonAddressDto() {}

    public PersonAddressDto(PersonDto person, AddressDto primary, AddressDto secondary) {
        this.person = person;
        this.primary = primary;
        this.secondary = secondary;
    }

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }

    public AddressDto getPrimary() {
        return primary;
    }

    public void setPrimary(AddressDto primary) {
        this.primary = primary;
    }

    public AddressDto getSecondary() {
        return secondary;
    }

    public void setSecondary(AddressDto secondary) {
        this.secondary = secondary;
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
