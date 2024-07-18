package hestia.msPersons.service;

import hestia.msPersons.payload.PersonDto;

import java.util.List;

public interface PersonService {

    List<PersonDto> findAllPersons();

    PersonDto getPersonById(int personId);

    PersonDto createPerson(PersonDto personDTO);

    PersonDto updatePerson(int personId, PersonDto personDTO);

    void deletePersonById(int personId);

}