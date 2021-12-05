package ca.mikegabelmann.demo2.controller.rest.repository;

import ca.mikegabelmann.demo2.persistence.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "persons", path = "persons")
public interface PersonRestRepository extends JpaRepository<Person, Long> {

}
