package ca.mikegabelmann.demo2.persistence.service;

import ca.mikegabelmann.demo2.persistence.model.GroupCode;
import ca.mikegabelmann.demo2.persistence.model.ModelTestFactory;
import ca.mikegabelmann.demo2.persistence.repository.GroupCodeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class GroupCodeServiceImplTest {
    @Mock
    private GroupCodeRepository groupCodeRepository;

    @InjectMocks
    private GroupCodeServiceImpl groupCodeService;

    private GroupCode gc1;
    private GroupCode gc2;

    @BeforeEach
    void setUp() {
        this.gc1 = ModelTestFactory.getGroupCode("PRO", "Province/State/Territory");
        this.gc2 = ModelTestFactory.getGroupCode("CNT", "Country");
    }

    @Test
    @DisplayName("results found")
    void findByGroupId1() {
        Mockito.when(groupCodeRepository.findById("PRO")).thenReturn(Optional.of(gc1));

        Optional<GroupCode> result = groupCodeService.findByGroupId("PRO");
        Assertions.assertTrue(result.isPresent());
    }

    @Test
    @DisplayName("no results")
    void findByGroupId2() {
        Mockito.when(groupCodeRepository.findById("BLA")).thenReturn(Optional.empty());

        Optional<GroupCode> result = groupCodeService.findByGroupId("BLA");
        Assertions.assertFalse(result.isPresent());
    }

}