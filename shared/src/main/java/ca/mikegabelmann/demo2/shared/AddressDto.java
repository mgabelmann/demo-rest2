package ca.mikegabelmann.demo2.shared;


public class AddressDto {
    private final Long id;
    private final String attention;
    private final String streetAddress;
    private final String city;
    private final String prov;
    private final String country;
    private final String postal;


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

    public String getAttention() {
        return attention;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getProv() {
        return prov;
    }

    public String getCountry() {
        return country;
    }

    public String getPostal() {
        return postal;
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
