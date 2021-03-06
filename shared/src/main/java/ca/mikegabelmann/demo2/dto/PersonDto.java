package ca.mikegabelmann.demo2.dto;

import java.time.LocalDate;


public class PersonDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthDt;
    private String sex;


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

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public LocalDate getBirthDt() {
        return birthDt;
    }

    public void setBirthDt(LocalDate birthDt) {
        this.birthDt = birthDt;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
