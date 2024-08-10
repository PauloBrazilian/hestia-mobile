package hestia.msPersons.application.ports.in;

import hestia.msPersons.domain.dto.PersonDto;

import java.util.List;

public interface PersonService {

    List<PersonDto> findAllPersons();

    PersonDto getPersonById(Long personId);

    List<PersonDto> findAllPersonByName(String name);

    PersonDto findByEmail(String email);

    PersonDto createPerson(PersonDto personDTO);

    PersonDto updatePerson(Long personId, PersonDto personDTO);

    void deletePersonById(Long personId);

}