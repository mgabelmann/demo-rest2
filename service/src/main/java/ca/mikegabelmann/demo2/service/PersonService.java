package ca.mikegabelmann.demo2.service;

import ca.mikegabelmann.demo2.dto.PersonDto;
import ca.mikegabelmann.demo2.persistence.model.SexCode;

import java.time.LocalDate;
import java.util.List;


public interface PersonService {

    List<PersonDto> findBySexAndBirthDt(String sex, LocalDate date);

}
