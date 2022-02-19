package ca.mikegabelmann.demo2.controller.rest.repository;

import ca.mikegabelmann.demo2.persistence.model.SexCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface SexCodeRestRepository extends JpaRepository<SexCode, String> {

}
