package hestia.msPersons.service;

import hestia.msPersons.config.ClassMapper;
import hestia.msPersons.entity.PersonBUSS;
import hestia.msPersons.exeptions.ProductAPIException;
import hestia.msPersons.payload.PersonBussDTO;
import hestia.msPersons.repository.PersonBussRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class PersonBussServiceIMPL implements PersonBussService{

    private PersonBussRepository bussRepository;

    private ClassMapper classMapper;

    @Autowired
    public PersonBussServiceIMPL(PersonBussRepository bussRepository, ClassMapper classMapper) {
        this.bussRepository = bussRepository;
        this.classMapper = classMapper;
    }

    @Override
    public List<PersonBussDTO> FindAllPersonsBus() {
        return bussRepository.findAll()
                .stream()
                .map(ClassMapper.INTANCE::personBussToDto)
                .collect(toList());
    }

    @Override
    public PersonBussDTO getPersonBusById(int personBussId) {
        Optional<PersonBUSS> personOptional = bussRepository.findById(personBussId);

        if (personOptional.isPresent()) {
            PersonBUSS personBUSS = personOptional.get();
            return ClassMapper.INTANCE.personBussToDto(personBUSS);
        } else {
            throw new EntityNotFoundException("Person with ID " + personBussId + " not found");
        }
    }

    @Override
    public PersonBussDTO createPersonBus(PersonBussDTO personBussDTO){
        var personBuss = ClassMapper.INTANCE.dtoToPersonBuss(personBussDTO);
        bussRepository.save(personBuss);
        return ClassMapper.INTANCE.personBussToDto(personBuss);
    }


    @Override
    public PersonBussDTO updatePersonBus(int personBussId, PersonBussDTO personBussDTO) {
        var search = bussRepository.findById(personBussId);

        if (search.isPresent()) {
            var personBuss = ClassMapper.INTANCE.dtoToPersonBuss(personBussDTO);
            bussRepository.save(personBuss);
            return ClassMapper.INTANCE.personBussToDto(personBuss);
        } else {
            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "PersonBUSS not found");
        }
    }

    @Override
    public void deletePersonBusById(int personBussId) {
        bussRepository.deleteById(personBussId);
    }


}
