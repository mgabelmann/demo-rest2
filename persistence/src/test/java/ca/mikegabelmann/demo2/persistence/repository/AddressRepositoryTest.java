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
import java.util.List;


@DataJpaTest
public class AddressRepositoryTest {

    private final SexCodeRepository sexCodeRepository;
    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    private SexCode s;
    private Person p;
    private Address a;


    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    public AddressRepositoryTest(SexCodeRepository sexCodeRepository, PersonRepository personRepository, AddressRepository addressRepository) {
        this.sexCodeRepository = sexCodeRepository;
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    @BeforeEach
    void beforeEach() {
        SexCode sTmp = new SexCode("M", "Male");
        this.s = sexCodeRepository.save(sTmp);

        Person pTmp = new Person(null, "firstName", "lastName", LocalDate.now(), s);
        this.p = personRepository.save(pTmp);

        Address aTmp = new Address(null, "streetAddress", "city", "prov", "country", "postal", p);
        this.a = addressRepository.save(aTmp);

        //sexcode does not have a generated ID
        Assertions.assertNotNull(p.getId());
        Assertions.assertNotNull(a.getId());
    }

    @Test
    @DisplayName("getReferenceById - with result")
    void test1_getReferenceById() {
        Address result = addressRepository.getReferenceById(a.getId());

        Assertions.assertNotNull(result);
    }

    @Test
    @DisplayName("getAddressByCountryAndProvAndCity - with results")
    void test1_getAddressByCountryAndProvAndCity() {
        List<Address> results = addressRepository.getAddressByCountryAndProvAndCity("country", "prov", "city");

        Assertions.assertNotNull(results);
        Assertions.assertEquals(1, results.size());
    }

    @Test
    @DisplayName("getAddressByCountryAndProvAndCity - without results")
    void test2_getAddressByCountryAndProvAndCity() {
        List<Address> results = addressRepository.getAddressByCountryAndProvAndCity("", "", "");

        Assertions.assertNotNull(results);
        Assertions.assertEquals(0, results.size());
    }

}
