package hestia.ms_security.domain.mapper;

import hestia.ms_security.domain.dto.LoginDto;
import hestia.ms_security.domain.entity.PersonRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClassMapper {

    LoginDto personToDto(PersonRole personRole);

    @Mapping(target = "id", ignore = true)
    PersonRole dtoToPerson(LoginDto personRoleDto);

}
