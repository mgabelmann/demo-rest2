package ca.mikegabelmann.demo2.persistence.repository;

import ca.mikegabelmann.demo2.persistence.model.SexCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
public class SexCodeRepositoryTest {

    private final SexCodeRepository sexCodeRepository;

    private SexCode s;


    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    public SexCodeRepositoryTest(SexCodeRepository sexCodeRepository) {
        this.sexCodeRepository = sexCodeRepository;
    }

    @BeforeEach
    void beforeEach() {
        SexCode sTmp = new SexCode("M", "Male");

        this.s = sexCodeRepository.save(sTmp);
    }

    @Test
    @DisplayName("getReferenceById - with result")
    void test1_getReferenceById() {
        SexCode result = sexCodeRepository.getReferenceById(s.getId());

        Assertions.assertNotNull(result);
    }

}
