package hestia.msPersons.application.ports.in;

import hestia.msPersons.domain.dto.PersonBussDto;
import hestia.msPersons.domain.dto.PersonDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PersonBussService {

    List<PersonBussDto> findAllPersonsBus();

    PersonBussDto getPersonBusById(Long personBussId);

    List<PersonBussDto> findAllPersonByName(String name);

    PersonBussDto findByEmail(String email);

    PersonBussDto createPersonBus(PersonBussDto personBussDTO);

    PersonBussDto updatePersonBus(Long personBussId, PersonBussDto personBussDTO);

    void deletePersonBusById(Long personBussId);

}