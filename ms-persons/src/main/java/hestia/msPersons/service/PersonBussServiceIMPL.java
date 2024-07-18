package hestia.msPersons.service;

import hestia.msPersons.config.ClassMapper;
import hestia.msPersons.entity.PersonBUSS;
import hestia.msPersons.exeptions.ProductAPIException;
import hestia.msPersons.payload.PersonBussDto;
import hestia.msPersons.repository.PersonBussRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@Service
public class PersonBussServiceIMPL implements PersonBussService {

    private PersonBussRepository bussRepository;
    private ClassMapper mapper;

    @Override
    public List<PersonBussDto> findAllPersonsBus() {
        return bussRepository.findAll()
                .stream()
                .map(mapper::personBussToDto)
                .collect(toList());
    }

    @Override
    public PersonBussDto getPersonBusById(int personBussId) {
        Optional<PersonBUSS> personOptional = bussRepository.findById(personBussId);

        if (personOptional.isPresent()) {
            PersonBUSS personBUSS = personOptional.get();
            return mapper.personBussToDto(personBUSS);
        } else {
            throw new EntityNotFoundException("Person with ID " + personBussId + " not found");
        }
    }

    @Override
    public PersonBussDto createPersonBus(PersonBussDto personBussDTO) {
        var personBuss = mapper.dtoToPersonBuss(personBussDTO);
        bussRepository.save(personBuss);
        return mapper.personBussToDto(personBuss);
    }


    @Override
    public PersonBussDto updatePersonBus(int personBussId, PersonBussDto personBussDTO) {
        var search = bussRepository.findById(personBussId);

        if (search.isPresent()) {
            var personBuss = mapper.dtoToPersonBuss(personBussDTO);
            bussRepository.save(personBuss);
            return mapper.personBussToDto(personBuss);
        } else {
            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "PersonBUSS not found");
        }
    }

    @Override
    public void deletePersonBusById(int personBussId) {
        bussRepository.deleteById(personBussId);
    }


}
