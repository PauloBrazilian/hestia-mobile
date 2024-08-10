package hestia.msPersons.application.ports.in;

import hestia.msPersons.domain.dto.RoleDto;
import org.springframework.web.bind.annotation.PathVariable;

public interface RoleService {

    RoleDto createRole(RoleDto roleDto);

    RoleDto findById(Long id);

    RoleDto findByEmail(String email);

}
