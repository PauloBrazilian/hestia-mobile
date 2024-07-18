package hestia.msPersons.config;

import hestia.msPersons.entity.Person;
import hestia.msPersons.entity.PersonBUSS;
import hestia.msPersons.payload.PersonBussDto;
import hestia.msPersons.payload.PersonDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClassMapper {

    PersonDto personToDto(Person person);

    Person dtoToPerson(PersonDto personDTO);

    PersonBussDto personBussToDto(PersonBUSS personBuss);

    PersonBUSS dtoToPersonBuss(PersonBussDto personBussDTO);

}