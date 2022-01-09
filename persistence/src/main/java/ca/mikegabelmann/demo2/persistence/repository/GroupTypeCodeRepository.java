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
     *
     * @param pGroupCode
     * @param pGroupTypeCode
     * @param groupCode
     * @return
     */
    @Query("SELECT g FROM GroupTypeCode g WHERE g.groupTypeCode.id.groupId = ?1 AND g.groupTypeCode.id.typeId = ?2 AND g.groupCode.groupId = ?3")
    List<GroupTypeCode> findGroupTypeCodesByParentType(String pGroupCode, String pGroupTypeCode, String groupCode);

}
