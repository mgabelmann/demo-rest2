package ca.mikegabelmann.demo2.persistence.repository;

import ca.mikegabelmann.demo2.persistence.model.GroupCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityNotFoundException;


@DataJpaTest
public class GroupCodeRepositoryTest {
    private GroupCodeRepository groupCodeRepository;

    private GroupCode gc1;


    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    public GroupCodeRepositoryTest(GroupCodeRepository groupCodeRepository) {
        this.groupCodeRepository = groupCodeRepository;
    }

    @BeforeEach
    void beforeEach() {
        this.gc1 = new GroupCode("CODE", "Description");
    }

    @Test
    @DisplayName("getById - with result")
    void test1_getById() {
        GroupCode result = groupCodeRepository.getById(gc1.getGroupId());

        Assertions.assertNotNull(result);
    }

    //NOTE: assertThrows is not working unless we include internal check. Why?
    @Test
    @DisplayName("getById - without result")
    void test2_getById() {
        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            GroupCode result = this.getRecord("XXXX");
            Assertions.assertNull(result);
        });
    }

    GroupCode getRecord(String id) throws Exception {
        return groupCodeRepository.getById(id);
    }

}
