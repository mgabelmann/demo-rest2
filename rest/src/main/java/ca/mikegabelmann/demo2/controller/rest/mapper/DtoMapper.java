package ca.mikegabelmann.demo2.controller.rest.mapper;

import ca.mikegabelmann.demo2.dto.AddressDto;
import ca.mikegabelmann.demo2.dto.PersonDto;
import ca.mikegabelmann.demo2.persistence.model.Address;
import ca.mikegabelmann.demo2.persistence.model.Person;
import ca.mikegabelmann.demo2.persistence.model.SexCode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


/**
 * Construct mapper between DTO and JPA entities. This process is tricky and error prone so unit tests are required!
 * Implementation is a Spring Component.
 */
@Mapper(componentModel = "spring")
public interface DtoMapper {

    @Mapping(source = "record.sexCode.id", target = "sex")
    PersonDto mapPersonDto(Person record);

    //@Mapping(source = "record.sex", target = "sexCode")
    //Person mapPerson(PersonDto record);

    List<PersonDto> mapListPersonDto(List<Person> records);
    //List<Person> mapListPerson(List<PersonDto> records);

    AddressDto mapAddressDto(Address record);
    //Address mapAddress(AddressDto record);

    List<AddressDto> mapListAddressDto(List<Address> records);
    //List<Address> mapListAddress(List<AddressDto> records);

    //NOTE: how to use or get description?
    @Mapping(source = "sex", target = "id")
    @Mapping(target = "description", ignore = true)
    SexCode mapSexCodeString(String sex);


/* NOTE: support for Optional<T> in Mapstruct is not working, wait for 1.6?

    @Named("fromOptional")
    default <T> T fromOptional(Optional<T> optional) {
        return optional.orElse(null);
    }
*/

    /*
    @Named("fromOptionalAddress")
    default Address fromOptionalAddress(Optional<Address> record) {
        return record.orElse(null);
    }

    AddressDto mapto(Optional<Address> record);

    @Mapping(source = "primaryAddress", target = "primary")
    @Mapping(source = "secondaryAddress", target = "secondary")
    PersonAddressDto mapPersonAddressDto(PersonAddress record);

    List<PersonAddressDto> mapListPersonAddress(List<PersonAddress> records);
    List<PersonAddress> mapListPersonAddressDto(List<PersonAddressDto> records);
    */
}
