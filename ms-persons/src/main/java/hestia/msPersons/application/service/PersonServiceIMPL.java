package hestia.msPersons.application.service;

import hestia.msPersons.application.ports.in.PersonService;
import hestia.msPersons.domain.config.ClassMapper;
import hestia.msPersons.domain.dto.PersonDto;
import hestia.msPersons.domain.dto.RoleDto;
import hestia.msPersons.domain.entity.Person;
import hestia.msPersons.domain.entity.Role;
import hestia.msPersons.framework.adapaters.out.PersonRepository;
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
public class PersonServiceIMPL implements PersonService {

    private final RoleRespository roleRepository;
    private PersonRepository personRepository;
    private ClassMapper mapper;

    @Override
    public List<PersonDto> findAllPersons() {
        return personRepository.findAll()
                .stream()
                .map(mapper::personToDto)
                .toList();
    }

    @Override
    public PersonDto getPersonById(Long personId) {
        Optional<Person> personOptional = personRepository.findById(personId);

        if (personOptional.isPresent()) {
            var personBUSS = personOptional.get();
            return mapper.personToDto(personBUSS);
        } else {
            throw new EntityNotFoundException("Person with ID " + personId + " not found");
        }
    }

    @Override
    public List<PersonDto> findAllPersonByName(String name) {
        return personRepository.findAllPersonByName(name)
                .stream()
                .map(mapper::personToDto)
                .toList();
    }

    @Override
    public PersonDto findByEmail(String email) {
        var person = personRepository.findByEmail(email);
        return mapper.personToDto(person);
    }

    @Override
    public PersonDto createPerson(PersonDto personDTO) {
        var person = mapper.dtoToPerson(personDTO);

        var existingRole = roleRepository.findByEmail(person.getEmail());

        if (existingRole.equals(true)) {
            Role role = createRole(personDTO.getRoleDto());
            person.setRole(role);
        }

        personRepository.save(person);
        return mapper.personToDto(person);
    }

    @Override
    public PersonDto updatePerson(Long personId, PersonDto personDTO) {
        var search = personRepository.findById(personId);

        if (search.isPresent()) {
            var person = mapper.dtoToPerson(personDTO);
            var role = new Role();
            role.setName(person.getName());
            role.setEmail(person.getEmail());
            roleRepository.save(role);
            personRepository.save(person);
            return mapper.personToDto(person);
        } else {
            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "Person not found");
        }
    }


    @Override
    public void deletePersonById(Long personId) {
        personRepository.deleteById(personId);
    }


    private Role createRole(RoleDto roleDto) {
        var role = mapper.dtoToRole(roleDto);
        return roleRepository.save(role);
    }

}
