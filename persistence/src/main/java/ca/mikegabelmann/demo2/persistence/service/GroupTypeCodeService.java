package ca.mikegabelmann.demo2.persistence.service;

import ca.mikegabelmann.demo2.persistence.model.GroupTypeCode;

import java.util.List;

public interface GroupTypeCodeService {

    /**
     *
     * @param pGroupId
     * @param pTypeId
     * @param groupId
     * @return
     */
    List<GroupTypeCode> findGroupTypeCodesByParentType(String pGroupId, String pTypeId, String groupId);

    /**
     *
     * @param groupId
     * @return
     */
    List<GroupTypeCode> findGroupTypeCodesByGroupId(String groupId);

}
