package ca.mikegabelmann.demo2.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;


@Entity
@Table(name = "ADDRESS")
public class Address {
    @Id
    @UuidGenerator
    @Column(name = "ADDRESS_ID", nullable = false, unique = true)
    private UUID id;

    /** Addressee. eg: John Jones */
    @Column(name = "ATTENTION", nullable = false, length = 100)
    private String attention;

    /** Additional delivery Information. eg: Marketing Dept */
    @Column(name = "DELIVERY_INFO", length = 100)
    private String deliveryInfo;

    /** Civic Address. eg: 1425 James St */
    @Column(name = "CIVIC_ADDRESS", length = 100)
    private String civicAddress;

    /** Postal box number and station information. eg: PO BOX 4001 STN A */
    @Column(name = "POSTAL_INFO", length = 100)
    private String postalInfo;

    /** Municipality name. eg: Victoria */
    @Column(name = "CITY", nullable = false, length = 100)
    private String city;

    /** Province, State or Territory. eg: BC */
    @Column(name = "PROV", nullable = false, length = 8)
    private String prov;

    /** Postal code, ZIP code, etc. eg: V8X 3X4 */
    @Column(name = "POSTAL", nullable = false, length = 16)
    private String postal;

    /** Country. eg: CA */
    @Column(name = "COUNTRY", nullable = false, length = 2)
    private String country;

    /** Primary or secondary address. */
    @Convert(converter = BooleanConverter.class)
    @Column(name = "PRIMARY_ADDRESS", nullable = false, length = 1)
    private Boolean primary;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID", nullable = false)
    private Person person;


    /** No args constructor, used by JPA. */
    protected Address() {
        this(null, null, null, null, null, null, null, null);
    }

    /** Required args constructor. */
    public Address(UUID id, String attention, String city, String prov, String postal, String country, Boolean primary, Person person) {
        this(id, attention, null, null, null, city, prov, postal, country, primary, person);
    }

    /** All args constructor. */
    public Address(UUID id, String attention, String deliveryInfo, String civicAddress, String postalInfo, String city, String prov, String postal, String country, Boolean primary, Person person) {
        this.id = id;
        this.attention = attention;
        this.deliveryInfo = deliveryInfo;
        this.civicAddress = civicAddress;
        this.postalInfo = postalInfo;
        this.city = city;
        this.prov = prov;
        this.postal = postal;
        this.country = country;
        this.primary = primary;
        this.person = person;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getDeliveryInfo() {
        return deliveryInfo;
    }

    public void setDeliveryInfo(String deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }

    public String getCivicAddress() {
        return civicAddress;
    }

    public void setCivicAddress(String civicAddress) {
        this.civicAddress = civicAddress;
    }

    public String getPostalInfo() {
        return postalInfo;
    }

    public void setPostalInfo(String postalInfo) {
        this.postalInfo = postalInfo;
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

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    /** Is this the primary address? */
    public boolean isPrimary() {
        return primary;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", attention='" + attention + '\'' +
                ", deliveryInfo='" + deliveryInfo + '\'' +
                ", civicAddress='" + civicAddress + '\'' +
                ", postalInfo='" + postalInfo + '\'' +
                ", city='" + city + '\'' +
                ", prov='" + prov + '\'' +
                ", postal='" + postal + '\'' +
                ", country='" + country + '\'' +
                ", primary=" + primary +
                //", person=" + person +
                '}';
    }
}
