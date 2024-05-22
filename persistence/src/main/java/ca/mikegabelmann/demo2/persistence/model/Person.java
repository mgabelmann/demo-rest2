package ca.mikegabelmann.demo2.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "PERSON")
public class Person {
    //TODO: change to use UUID
    @Id
    @SequenceGenerator(name = "seq_person", sequenceName = "person_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_person")
    @Column(name = "PERSON_ID", nullable = false, unique = true)
    private Long id;

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
        final Long id,
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
                ", addresses=" + addresses +
                '}';
    }

}
