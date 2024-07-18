package hestia.msPersons.service;

import hestia.msPersons.payload.PersonBussDto;

import java.util.List;

public interface PersonBussService {

    List<PersonBussDto> findAllPersonsBus();

    PersonBussDto getPersonBusById(int personBussId);

    PersonBussDto createPersonBus(PersonBussDto personBussDTO);

    PersonBussDto updatePersonBus(int personBussId, PersonBussDto personBussDTO);

    void deletePersonBusById(int personBussId);

}