package ca.mikegabelmann.demo2.persistence.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "PERSON")
public class Person {

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

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "SEX", length = 1, nullable = false)
    private Sex sex;

    @OneToMany(mappedBy = "person")
    private final List<Address> addresses = new ArrayList<>();


    /** Constructor. */
    public Person() {}

    /** Constructor. */
    public Person(Long id, String firstName, String lastName, LocalDate birthDt, Sex sex) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

}