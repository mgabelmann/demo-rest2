package ca.mikegabelmann.demo2.dto;


import org.hibernate.validator.constraints.Length;

public class AddressDto {
    private Long id;
    private String attention;
    private String streetAddress;
    private String city;
    private String prov;
    private String country;
    private String postal;


    public AddressDto() {
        this(null, "", "", "", "", "", "");
    }

    public AddressDto(Long id, String attention, String streetAddress, String city, String prov, String country, String postal) {
        this.id = id;
        this.attention = attention;
        this.streetAddress = streetAddress;
        this.city = city;
        this.prov = prov;
        this.country = country;
        this.postal = postal;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AddressDto{");

        sb.append("id=").append(id);
        sb.append(", attention='").append(attention).append('\'');
        sb.append(", streetAddress='").append(streetAddress).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", prov='").append(prov).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", postal='").append(postal).append('\'');
        sb.append('}');

        return sb.toString();
    }

}
