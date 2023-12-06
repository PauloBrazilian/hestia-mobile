package hestia.msPersons.config;

import hestia.msPersons.entity.Person;
import hestia.msPersons.entity.PersonBUSS;
import hestia.msPersons.payload.PersonBussDTO;
import hestia.msPersons.payload.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClassMapper {

    ClassMapper INTANCE = Mappers.getMapper(ClassMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "personImg", target = "personImg")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    PersonDTO personToDto (Person person);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "personImg", target = "personImg")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    Person dtoToPerson (PersonDTO personDTO);

    PersonBussDTO personBussToDto (PersonBUSS personBuss);

    PersonBUSS dtoToPersonBuss (PersonBussDTO personBussDTO);

}