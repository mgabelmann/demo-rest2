package ca.mikegabelmann.demo2.persistence.repository;

import ca.mikegabelmann.demo2.persistence.model.GroupCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import jakarta.persistence.EntityNotFoundException;


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
    @DisplayName("getReferenceById - with result")
    void test1_getReferenceById() {
        GroupCode result = groupCodeRepository.getReferenceById(gc1.getGroupId());

        Assertions.assertNotNull(result);
    }

    //NOTE: doesn't throw exception until you first try and access object
    @Test
    @DisplayName("getReferenceById - without result")
    void test2_getReferenceById() {
        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            GroupCode gc = groupCodeRepository.getReferenceById("XXXX");
            gc.toString();
        });
    }


}
