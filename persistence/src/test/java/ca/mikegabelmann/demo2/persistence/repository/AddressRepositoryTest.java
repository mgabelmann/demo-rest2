package ca.mikegabelmann.demo2.persistence.repository;

import ca.mikegabelmann.demo2.persistence.model.Address;
import ca.mikegabelmann.demo2.persistence.model.Person;
import ca.mikegabelmann.demo2.persistence.model.SexCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;


@DataJpaTest
public class AddressRepositoryTest {
    @Autowired
    private SexCodeRepository sexCodeRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    private SexCode s;
    private Person p;
    private Address a;


    @BeforeEach
    void beforeEach() {
        SexCode sTmp = new SexCode("M", "Male");
        Person pTmp = new Person(null, "firstName", "lastName", LocalDate.now(), sTmp);
        Address aTmp = new Address(null, "streetAddress", "city", "prov", "country", "postal", pTmp);

        this.s = sexCodeRepository.save(sTmp);
        sexCodeRepository.flush();

        this.p = personRepository.save(pTmp);
        this.a = addressRepository.save(aTmp);

        Assertions.assertNotNull(s);
        Assertions.assertNotNull(p.getId());
        Assertions.assertNotNull(a.getId());
    }

    @Test
    @DisplayName("getById - with result")
    void test1_getById() {
        Address result = addressRepository.getById(a.getId());

        Assertions.assertNotNull(result);
    }

}