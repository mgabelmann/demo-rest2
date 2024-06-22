package ca.mikegabelmann.demo2.persistence.service;

import ca.mikegabelmann.demo2.persistence.model.GroupCode;
import ca.mikegabelmann.demo2.persistence.model.GroupTypeCode;
import ca.mikegabelmann.demo2.persistence.model.ModelTestFactory;
import ca.mikegabelmann.demo2.persistence.repository.GroupTypeCodeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class GroupTypeCodeServiceImplTest {
    @Mock
    private GroupTypeCodeRepository groupTypeCodeRepository;

    @InjectMocks
    private GroupTypeCodeServiceImpl service;

    private GroupCode gc1;
    private GroupCode gc2;
    private GroupTypeCode gtc1;
    private GroupTypeCode gtc2;
    private GroupTypeCode gtc3;

    @BeforeEach
    void setUp() {
        this.gc1 = ModelTestFactory.getGroupCode("CNT", "Country");
        this.gc2 = ModelTestFactory.getGroupCode("PRO", "Province/State/Territory");

        this.gtc1 = ModelTestFactory.getGroupTypeCode("CA", "Canada", 1, true, gc1, null);
        this.gtc2 = ModelTestFactory.getGroupTypeCode("BC", "British Columbia", 1, true, gc2, gtc1);
        this.gtc3 = ModelTestFactory.getGroupTypeCode("AB", "Alberta", 1, true, gc2, gtc1);
    }

    @Test
    void findGroupTypeCodesByParentType() {
        Mockito.when(groupTypeCodeRepository.findGroupTypeCodesByParentType("CNT", "CA", "PRO")).thenReturn(List.of(gtc2, gtc3));

        List<GroupTypeCode> results = service.findGroupTypeCodesByParentType("CNT", "CA", "PRO");
        Assertions.assertNotNull(results);
        Assertions.assertEquals(2, results.size());
    }

    @Test
    void findGroupTypeCodesByGroupId() {
        Mockito.when(groupTypeCodeRepository.findGroupTypeCodesByGroupId("CA")).thenReturn(List.of(gtc1));

        List<GroupTypeCode> results = service.findGroupTypeCodesByGroupId("CA");
        Assertions.assertNotNull(results);
        Assertions.assertEquals(1, results.size());
    }

}