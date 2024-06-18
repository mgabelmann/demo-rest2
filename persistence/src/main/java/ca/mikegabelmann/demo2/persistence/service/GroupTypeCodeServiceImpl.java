package ca.mikegabelmann.demo2.persistence.service;

import ca.mikegabelmann.demo2.persistence.model.GroupTypeCode;
import ca.mikegabelmann.demo2.persistence.repository.GroupTypeCodeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupTypeCodeServiceImpl implements GroupTypeCodeService {
    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(GroupTypeCodeServiceImpl.class);

    private final GroupTypeCodeRepository groupTypeCodeRepository;


    @Autowired
    public GroupTypeCodeServiceImpl(final GroupTypeCodeRepository groupTypeCodeRepository) {
        this.groupTypeCodeRepository = groupTypeCodeRepository;
    }

    @Override
    public List<GroupTypeCode> findGroupTypeCodesByParentType(final String pGroupId, final String pTypeId, final String groupId) {
        return groupTypeCodeRepository.findGroupTypeCodesByParentType(pGroupId, pTypeId, groupId);
    }

    @Override
    public List<GroupTypeCode> findGroupTypeCodesByGroupId(final String groupId) {
        return groupTypeCodeRepository.findGroupTypeCodesByGroupId(groupId);
    }

}
