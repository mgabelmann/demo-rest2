package ca.mikegabelmann.demo2.service;


import ca.mikegabelmann.demo2.persistence.model.Sex;
import ca.mikegabelmann.demo2.dto.PersonDto;

import java.time.LocalDate;
import java.util.List;

public interface PersonService {

    List<PersonDto> findBySexAndBirthDt(Sex sex, LocalDate date);

}
