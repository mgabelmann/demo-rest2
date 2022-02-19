package ca.mikegabelmann.demo2.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @SequenceGenerator(name = "seq_address", sequenceName = "address_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_address")
    @Column(name = "ADDRESS_ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "ATTENTION", length = 100)
    private String attention;

    @Column(name = "STREET_ADDRESS", nullable = false, length = 100)
    private String streetAddress;

    @Column(name = "CITY", nullable = false, length = 100)
    private String city;

    @Column(name = "PROV", nullable = false, length = 100)
    private String prov;

    @Column(name = "COUNTRY", nullable = false, length = 100)
    private String country;

    @Column(name = "POSTAL", nullable = false, length = 25)
    private String postal;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;


    /** No args constructor. */
    public Address() {}

    /** Required args constructor. */
    public Address(
        final Long id,
        final String streetAddress,
        final String city,
        final String prov,
        final String country,
        final String postal,
        final Person person) {

        this.id = id;
        this.streetAddress = streetAddress;
        this.city = city;
        this.prov = prov;
        this.country = country;
        this.postal = postal;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("id=").append(id);
        sb.append(", attention='").append(attention).append('\'');
        sb.append(", streetAddress='").append(streetAddress).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", prov='").append(prov).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", postal='").append(postal).append('\'');
        sb.append(", person=").append(person);
        sb.append('}');

        return sb.toString();
    }

}
