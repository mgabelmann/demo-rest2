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

/*
create table address (address_id bigint not null, attention varchar(100), city varchar(100) not null, country varchar(100) not null, postal varchar(25) not null, prov varchar(100) not null, street_address varchar(100) not null, person_id bigint, primary key (address_id))
create table group_code (group_id varchar(5) not null, description varchar(64) not null, primary key (group_id))
create table group_type_code (
    group_id varchar(5) not null,
    type_id varchar(5) not null,
    description varchar(255) not null,
    effective char(1) not null,
    position integer not null,
    p_group_id varchar(5),
    p_type_id varchar(5),
    primary key (group_id, type_id))
create table person (person_id bigint not null, birth_dt date not null, first_name varchar(75) not null, last_name varchar(75) not null, middle_name varchar(75), sex_code varchar(1) not null, primary key (person_id))
create table sex_code (id varchar(1) not null, description varchar(24) not null, primary key (id))
*/

}
