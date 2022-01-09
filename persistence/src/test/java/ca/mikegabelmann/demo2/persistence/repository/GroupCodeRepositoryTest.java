package ca.mikegabelmann.demo2.persistence.repository;

import ca.mikegabelmann.demo2.persistence.model.GroupCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


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

    //FIXME: why doesnt this catch the error? The commented code throws it?
    @Test
    @DisplayName("getById - without result")
    void test2_getById() {
        //GroupCode result = groupCodeRepository.getById("code");
        //Assertions.assertNull(result);

        //Assertions.assertThrows(EntityNotFoundException.class, () -> groupCodeRepository.getById("xxxx"));
    }

}
