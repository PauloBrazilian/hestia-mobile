package hestia.msPersons.application.ports.in;

import hestia.msPersons.domain.dto.RoleDto;

public interface RoleService {

    RoleDto createRole(RoleDto roleDto);

    RoleDto findById(Long id);

    RoleDto findByEmail(String email);

}
