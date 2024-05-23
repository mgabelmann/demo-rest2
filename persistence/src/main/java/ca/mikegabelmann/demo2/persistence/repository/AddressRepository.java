package ca.mikegabelmann.demo2.persistence.repository;

import ca.mikegabelmann.demo2.persistence.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {

    /**
     * Get all addresses for a country, prov and city.
     * @param country country
     * @param prov province/state
     * @param city city
     * @return records
     */
    List<Address> getAddressByCountryAndProvAndCity(String country, String prov, String city);

}
