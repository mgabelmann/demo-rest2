package ca.mikegabelmann.demo2.persistence.repository;

import ca.mikegabelmann.demo2.persistence.model.GroupCode;
import ca.mikegabelmann.demo2.persistence.model.GroupTypeCode;
import ca.mikegabelmann.demo2.persistence.model.GroupTypeCodeId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class GroupTypeCodeRepositoryTest {
    private GroupCodeRepository groupCodeRepository;
    private GroupTypeCodeRepository groupTypeCodeRepository;

    private GroupCode gc1;
    private GroupTypeCode gtc1;


    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    public GroupTypeCodeRepositoryTest(
        GroupCodeRepository groupCodeRepository,
        GroupTypeCodeRepository groupTypeCodeRepository) {

        this.groupCodeRepository = groupCodeRepository;
        this.groupTypeCodeRepository = groupTypeCodeRepository;
    }

    @BeforeEach
    void beforeEach() {
        this.gc1 = groupCodeRepository.save(new GroupCode("CNTRY", "Country"));

        GroupTypeCode tmpGtc1 = new GroupTypeCode(new GroupTypeCodeId("CNTRY", "CAN"), "Canada", 1, Boolean.TRUE, gc1, null);
        this.gtc1 = groupTypeCodeRepository.save(tmpGtc1);
    }

    @Test
    @DisplayName("getById - with result")
    void test1_getById() {
        GroupTypeCode result = groupTypeCodeRepository.getById(gtc1.getId());

        Assertions.assertNotNull(result);
    }

    //NOTE: even though this is a 'new' record, it has the same primary key so an update is done instead.
    @Test
    @DisplayName("no duplicate created, updates instead")
    void test2_duplicateId() {
        GroupTypeCode tmpGtc1 = new GroupTypeCode(new GroupTypeCodeId("CNTRY", "CAN"), "Canbodia", 2, Boolean.FALSE, gc1, null);
        groupTypeCodeRepository.save(tmpGtc1);

        Assertions.assertEquals("Canbodia", gtc1.getDescription());
        Assertions.assertEquals(2, gtc1.getPosition());
        Assertions.assertEquals(Boolean.FALSE, gtc1.getEffective());
    }

    @Test
    @DisplayName("findGroupTypeCodesByParentType - with result")
    void test1_findGroupTypeCodesByParentType() {
        GroupCode gc2 = groupCodeRepository.save(new GroupCode("PRO", "Province or State"));

        //link this record to another GroupTypeCode
        GroupTypeCode tmpGtc2 = new GroupTypeCode(new GroupTypeCodeId("PRO", "BC"), "British Columbia", 2, Boolean.TRUE, gc2, gtc1);
        groupTypeCodeRepository.save(tmpGtc2);

        GroupTypeCode tmpGtc3 = new GroupTypeCode(new GroupTypeCodeId("CNTRY", "USA"), "United States", 2, Boolean.TRUE, gc1, null);
        groupTypeCodeRepository.save(tmpGtc3);

        GroupTypeCode tmpGtc4 = new GroupTypeCode(new GroupTypeCodeId("PRO", "CA"), "California", 3, Boolean.TRUE, gc2, tmpGtc3);
        groupTypeCodeRepository.save(tmpGtc4);

        {
            List<GroupTypeCode> results = groupTypeCodeRepository.findGroupTypeCodesByParentType("CNTRY", "CAN", "PRO");
            Assertions.assertNotNull(results);
            Assertions.assertEquals(1, results.size());
            Assertions.assertEquals(tmpGtc2.getId(), results.get(0).getId());
        }
        {
            List<GroupTypeCode> results = groupTypeCodeRepository.findGroupTypeCodesByParentType("CNTRY", "USA", "PRO");
            Assertions.assertNotNull(results);
            Assertions.assertEquals(1, results.size());
            Assertions.assertEquals(tmpGtc4.getId(), results.get(0).getId());
        }
    }

}
