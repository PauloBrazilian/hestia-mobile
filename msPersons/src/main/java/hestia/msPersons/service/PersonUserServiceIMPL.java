package hestia.msPersons.service;

import hestia.msPersons.config.ClassMapper;
import hestia.msPersons.entity.Person;
import hestia.msPersons.exeptions.ProductAPIException;
import hestia.msPersons.payload.PersonDTO;
import hestia.msPersons.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class PersonUserServiceIMPL implements PersonUserService {

    private PersonRepository personRepository;

    private ClassMapper classMapper;


    @Autowired
    public PersonUserServiceIMPL(PersonRepository personRepository, ClassMapper classMapper) {
        this.personRepository = personRepository;
        this.classMapper = classMapper;
    }


    @Override
    public List<PersonDTO> FindAllPersons() {
        return personRepository.findAll()
                .stream()
                .map(ClassMapper.INTANCE::personToDto)
                .collect(toList());
    }

    @Override
    public PersonDTO getPersonById(int personId) {
        Optional<Person> personOptional = personRepository.findById(personId);

        if (personOptional.isPresent()) {
            var personBUSS = personOptional.get();
            return ClassMapper.INTANCE.personToDto(personBUSS);
        } else {
            throw new EntityNotFoundException("Person with ID " + personId + " not found");
        }
    }

    @Override
    public PersonDTO createPerson(PersonDTO personDTO) {
        var person = ClassMapper.INTANCE.dtoToPerson(personDTO);
        personRepository.save(person);
        return ClassMapper.INTANCE.personToDto(person);
    }

    @Override
    public PersonDTO updatePerson(int personId, PersonDTO personDTO) {
        var search = personRepository.findById(personId);

        if (search.isPresent()) {
            var person = ClassMapper.INTANCE.dtoToPerson(personDTO);
            personRepository.save(person);
            return ClassMapper.INTANCE.personToDto(person);
        } else {
            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "Person not found");
        }
    }


    @Override
    public void deletePersonById(int personId) {
        personRepository.deleteById(personId);
    }


}
