package ca.mikegabelmann.demo2.persistence.facade;

import ca.mikegabelmann.demo2.persistence.facade.bean.PersonAddress;

import java.util.Optional;
import java.util.UUID;


public interface PersonFacade {

    /**
     * Get person and addresses given person id.
     * @param id person id
     * @return record if it exists
     */
    Optional<PersonAddress> getPersonAddress(UUID id);

}
