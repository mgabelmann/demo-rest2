package ca.mikegabelmann.demo2.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "PERSON")
public class Person {
    @Id
    @UuidGenerator
    @Column(name = "PERSON_ID", nullable = false, unique = true)
    private UUID id;

    @Column(name = "FIRST_NAME", length = 75, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 75, nullable = false)
    private String lastName;

    @Column(name = "MIDDLE_NAME", length = 75)
    private String middleName;

    @Column(name = "BIRTH_DT", nullable = false)
    private LocalDate birthDt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SEX_CODE", nullable = false)
    private SexCode sexCode;

    @OneToMany(mappedBy = "person")
    private List<Address> addresses = new ArrayList<>();


    /** No args constructor, used by JPA. */
    protected Person() {
        this(null, null, null, null, null);
    }

    /** Required args constructor. */
    public Person(
        final UUID id,
        final String firstName,
        final String lastName,
        final LocalDate birthDt,
        final SexCode sexCode) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDt = birthDt;
        this.sexCode = sexCode;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public SexCode getSexCode() {
        return sexCode;
    }

    public void setSexCode(SexCode sexCode) {
        this.sexCode = sexCode;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthDt=" + birthDt +
                ", sexCode=" + sexCode +
                //", addresses=" + addresses +
                '}';
    }

}
