package hestia.msPersons.service;

import hestia.msPersons.config.ClassMapper;
import hestia.msPersons.entity.Person;
import hestia.msPersons.exeptions.ProductAPIException;
import hestia.msPersons.payload.PersonDto;
import hestia.msPersons.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@Service
public class PersonServiceIMPL implements PersonService {

    private PersonRepository personRepository;
    private ClassMapper mapper;

    @Override
    public List<PersonDto> findAllPersons() {
        return personRepository.findAll()
                .stream()
                .map(mapper::personToDto)
                .collect(toList());
    }

    @Override
    public PersonDto getPersonById(int personId) {
        Optional<Person> personOptional = personRepository.findById(personId);

        if (personOptional.isPresent()) {
            var personBUSS = personOptional.get();
            return mapper.personToDto(personBUSS);
        } else {
            throw new EntityNotFoundException("Person with ID " + personId + " not found");
        }
    }

    @Override
    public PersonDto createPerson(PersonDto personDTO) {
        var person = mapper.dtoToPerson(personDTO);
        personRepository.save(person);
        return mapper.personToDto(person);
    }

    @Override
    public PersonDto updatePerson(int personId, PersonDto personDTO) {
        var search = personRepository.findById(personId);

        if (search.isPresent()) {
            var person = mapper.dtoToPerson(personDTO);
            personRepository.save(person);
            return mapper.personToDto(person);
        } else {
            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "Person not found");
        }
    }


    @Override
    public void deletePersonById(int personId) {
        personRepository.deleteById(personId);
    }


}
