package ca.mikegabelmann.demo2.persistence.repository;

import ca.mikegabelmann.demo2.persistence.model.GroupTypeCode;
import ca.mikegabelmann.demo2.persistence.model.GroupTypeCodeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GroupTypeCodeRepository extends JpaRepository<GroupTypeCode, GroupTypeCodeId> {

    /**
     * Find group type codes.
     * @param pGroupCode parent group
     * @param pGroupTypeCode parent group type
     * @param groupCode group
     * @return records
     */
    @Query("SELECT g FROM GroupTypeCode g WHERE g.groupTypeCode.id.groupId = ?1 AND g.groupTypeCode.id.typeId = ?2 AND g.groupCode.groupId = ?3 ORDER BY g.description")
    List<GroupTypeCode> findGroupTypeCodesByParentType(String pGroupCode, String pGroupTypeCode, String groupCode);

    /**
     * Find group type codes.
     * @param groupId group
     * @return records
     */
    @Query("SELECT g FROM GroupTypeCode g WHERE g.id.groupId = ?1 ORDER BY g.description")
    List<GroupTypeCode> findGroupTypeCodesByGroupId(String groupId);

}
