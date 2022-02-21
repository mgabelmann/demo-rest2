package ca.mikegabelmann.demo2.controller.rest.mapper;

import ca.mikegabelmann.demo2.dto.AddressDto;
import ca.mikegabelmann.demo2.dto.PersonAddressDto;
import ca.mikegabelmann.demo2.dto.PersonDto;
import ca.mikegabelmann.demo2.persistence.model.Address;
import ca.mikegabelmann.demo2.persistence.model.Person;
import ca.mikegabelmann.demo2.persistence.model.SexCode;
import ca.mikegabelmann.demo2.service.dto.PersonAddress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Construct mapper between DTO and JPA entities. This process is tricky and error prone so unit tests are required!
 *
 */
@Mapper(componentModel = "spring")
public interface DtoMapper {

    @Mapping(source = "record.sexCode.id", target = "sex")
    PersonDto mapPersonDto(Person record);

    @Mapping(source = "record.sex", target = "sexCode")
    Person mapPerson(PersonDto record);

    List<PersonDto> mapListPersonDto(List<Person> records);
    List<Person> mapListPerson(List<PersonDto> records);

    AddressDto mapAddressDto(Address record);
    Address mapAddress(AddressDto record);

    List<AddressDto> mapListAddressDto(List<Address> records);
    List<Address> mapListAddress(List<AddressDto> records);

    PersonAddressDto mapPersonAddressDto(PersonAddress record);
    PersonAddress mapPersonAddress(PersonAddressDto record);

    List<PersonAddressDto> mapListPersonAddress(List<PersonAddress> records);
    List<PersonAddress> mapListPersonAddressDto(List<PersonAddressDto> records);

    //NOTE: how to use or get description?
    @Mapping(source = "sex", target = "id")
    @Mapping(target = "description", ignore = true)
    SexCode mapSexCodeString(String sex);
}
