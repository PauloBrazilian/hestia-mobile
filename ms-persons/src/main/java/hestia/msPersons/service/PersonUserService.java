package hestia.msPersons.service;



import hestia.msPersons.entity.Person;
import hestia.msPersons.payload.PersonDTO;

import java.util.List;

public interface PersonUserService {

    public List<PersonDTO> FindAllPersons();

    public PersonDTO getPersonById(int personId);

    public PersonDTO createPerson(PersonDTO personDTO);

    public PersonDTO updatePerson(int personId, PersonDTO personDTO);

    public void deletePersonById(int personId);

}