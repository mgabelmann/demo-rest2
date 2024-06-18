package ca.mikegabelmann.demo2.persistence.service;

import ca.mikegabelmann.demo2.persistence.model.GroupCode;

import java.util.Optional;

public interface GroupCodeService {

    /**
     *
     * @param groupId
     * @return
     */
    Optional<GroupCode> findByGroupId(String groupId);

}
