package ca.mikegabelmann.demo2.controller.rest.repository;

import ca.mikegabelmann.demo2.persistence.model.GroupCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface GroupCodeRestRepository extends JpaRepository<GroupCode, String> {

}
