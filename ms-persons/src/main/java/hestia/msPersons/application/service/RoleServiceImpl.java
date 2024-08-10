package hestia.msPersons.application.service;

import hestia.msPersons.application.ports.in.RoleService;
import hestia.msPersons.domain.config.ClassMapper;
import hestia.msPersons.domain.dto.RoleDto;
import hestia.msPersons.framework.adapaters.out.RoleRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRespository repository;
    private final ClassMapper mapper;

    @Override
    public RoleDto createRole(RoleDto roleDto) {
        var role = mapper.dtoToRole(roleDto);
        repository.save(role);
        return mapper.roleToDto(role);
    }

    @Override
    public RoleDto findById(Long id) {
        var role = repository.findById(id).orElseThrow(RuntimeException::new);
        return mapper.roleToDto(role);
    }

    @Override
    public RoleDto findByEmail(String email) {
        var role = repository.findByEmail(email);
        return mapper.roleToDto(role);
    }

}
