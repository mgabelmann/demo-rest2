package ca.mikegabelmann.demo2.persistence.repository;

import ca.mikegabelmann.demo2.persistence.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    /**
     * Get people by sex and birth date.
     * @param sexcode sex
     * @param date birth date
     * @return records
     */
    List<Person> findBySexCodeIdAndBirthDt(String sexcode, LocalDate date);

}
