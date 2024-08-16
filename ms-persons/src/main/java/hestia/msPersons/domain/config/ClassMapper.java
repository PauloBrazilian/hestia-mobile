package hestia.msPersons.domain.config;

import hestia.msPersons.domain.dto.PersonBussDto;
import hestia.msPersons.domain.dto.PersonDto;
import hestia.msPersons.domain.dto.RoleDto;
import hestia.msPersons.domain.entity.Person;
import hestia.msPersons.domain.entity.PersonBUSS;
import hestia.msPersons.domain.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClassMapper {

    @Mapping(source = "role", target = "roleDto")
    PersonDto personToDto(Person person);

    @Mapping(source = "roleDto", target = "role")
    Person dtoToPerson(PersonDto personDTO);

    @Mapping(source = "role", target = "roleDto")
    PersonBussDto personBussToDto(PersonBUSS personBuss);

    @Mapping(source = "roleDto", target = "role")
    PersonBUSS dtoToPersonBuss(PersonBussDto personBussDTO);

    RoleDto roleToDto(Role role);

    Role dtoToRole(RoleDto roleDto);

}