package ca.mikegabelmann.demo2.controller.rest.repository;

import ca.mikegabelmann.demo2.persistence.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "addresses",
    path = "addresses"
)
public interface AddressRestRepository extends JpaRepository<Address, Long> {

}
