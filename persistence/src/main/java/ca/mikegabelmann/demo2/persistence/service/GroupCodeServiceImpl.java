package ca.mikegabelmann.demo2.persistence.service;

import ca.mikegabelmann.demo2.persistence.model.GroupCode;
import ca.mikegabelmann.demo2.persistence.repository.GroupCodeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class GroupCodeServiceImpl implements GroupCodeService {
    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(GroupCodeServiceImpl.class);

    private final GroupCodeRepository groupCodeRepository;


    @Autowired
    public GroupCodeServiceImpl(GroupCodeRepository groupCodeRepository) {
        this.groupCodeRepository = groupCodeRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<GroupCode> findByGroupId(String groupId) {
        return groupCodeRepository.findById(groupId);
    }

}
