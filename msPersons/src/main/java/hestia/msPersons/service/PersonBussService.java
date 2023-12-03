package hestia.msPersons.service;



import hestia.msPersons.entity.PersonBUSS;
import hestia.msPersons.payload.PersonBussDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonBussService {

    public List<PersonBussDTO> FindAllPersonsBus();

    public PersonBussDTO getPersonBusById(int personBussId);

    public PersonBussDTO createPersonBus(PersonBussDTO personBussDTO);

    public PersonBussDTO updatePersonBus(int personBussId, PersonBussDTO personBussDTO);

    public void deletePersonBusById(int personBussId);

}