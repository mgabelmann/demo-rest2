package ca.mikegabelmann.demo2.dto;

import java.time.LocalDate;


public class PersonDto {
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final LocalDate birthDt;
    private final String sex;


    public PersonDto() {
        this(null, "", "", "", null, "");
    }

    public PersonDto(Long id, String firstName, String lastName, String middleName, LocalDate birthDt, String sex) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDt = birthDt;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public LocalDate getBirthDt() {
        return birthDt;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PersonDto{");

        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", middleName='").append(middleName).append('\'');
        sb.append(", birthDt=").append(birthDt);
        sb.append(", sex='").append(sex).append('\'');
        sb.append('}');

        return sb.toString();
    }

}
