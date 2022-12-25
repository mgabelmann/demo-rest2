package ca.mikegabelmann.demo2.persistence.facade;

import ca.mikegabelmann.demo2.persistence.service.dto.PersonAddress;

import java.util.Optional;


public interface PersonFacade {

    /**
     * Get person and addresses given person id.
     * @param id person id
     * @return record if it exists
     */
    Optional<PersonAddress> getPersonAddress(Long id);

}
