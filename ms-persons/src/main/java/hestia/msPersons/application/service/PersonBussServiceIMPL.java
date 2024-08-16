package hestia.msPersons.application.service;

import hestia.msPersons.application.ports.in.PersonBussService;
import hestia.msPersons.domain.config.ClassMapper;
import hestia.msPersons.domain.dto.PersonBussDto;
import hestia.msPersons.domain.dto.RoleDto;
import hestia.msPersons.domain.entity.PersonBUSS;
import hestia.msPersons.domain.entity.Role;
import hestia.msPersons.framework.adapaters.out.PersonBussRepository;
import hestia.msPersons.framework.adapaters.out.RoleRespository;
import hestia.msPersons.framework.exeptions.ProductAPIException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PersonBussServiceIMPL implements PersonBussService {

    private final RoleRespository roleRepository;
    private PersonBussRepository bussRepository;
    private ClassMapper mapper;

    @Override
    public List<PersonBussDto> findAllPersonsBus() {
        return bussRepository.findAll()
                .stream()
                .map(mapper::personBussToDto)
                .toList();
    }

    @Override
    public PersonBussDto getPersonBusById(Long personBussId) {
        Optional<PersonBUSS> personOptional = bussRepository.findById(personBussId);

        if (personOptional.isPresent()) {
            PersonBUSS personBUSS = personOptional.get();
            return mapper.personBussToDto(personBUSS);
        } else {
            throw new EntityNotFoundException("Person with ID " + personBussId + " not found");
        }
    }

    @Override
    public List<PersonBussDto> findAllPersonByName(String name) {
        return bussRepository.findAllPersonByName(name)
                .stream()
                .map(mapper::personBussToDto)
                .toList();
    }

    @Override
    public PersonBussDto findByEmail(String email) {
        var personBuss = bussRepository.findByEmail(email);
        return mapper.personBussToDto(personBuss);
    }

    @Override
    public PersonBussDto createPersonBus(PersonBussDto personBussDTO) {
        var personBuss = mapper.dtoToPersonBuss(personBussDTO);

        var existingRole = roleRepository.findByEmail(personBuss.getEmail());

        if (existingRole == null) {
            Role role = createRole(personBussDTO.getRoleDto());
            personBuss.setRole(role);
        }

        personBuss.setRole(existingRole);
        bussRepository.save(personBuss);
        return mapper.personBussToDto(personBuss);
    }


    @Override
    public PersonBussDto updatePersonBus(Long personBussId, PersonBussDto personBussDTO) {
        var search = bussRepository.findById(personBussId);

        if (search.isPresent()) {
            var personBuss = mapper.dtoToPersonBuss(personBussDTO);
            var role = new Role();
            role.setName(personBuss.getName());
            role.setEmail(personBuss.getEmail());
            roleRepository.save(role);
            bussRepository.save(personBuss);
            return mapper.personBussToDto(personBuss);
        } else {
            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "PersonBUSS not found");
        }
    }

    @Override
    public void deletePersonBusById(Long personBussId) {
        bussRepository.deleteById(personBussId);
    }


    private Role createRole(RoleDto roleDto) {
        var role = mapper.dtoToRole(roleDto);
        return roleRepository.save(role);
    }

}
