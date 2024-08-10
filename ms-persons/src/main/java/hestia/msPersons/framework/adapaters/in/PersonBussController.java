package hestia.msPersons.framework.adapaters.in;

import hestia.msPersons.domain.dto.PersonBussDto;
import hestia.msPersons.application.service.PersonBussServiceIMPL;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personBus")
@AllArgsConstructor
public class PersonBussController {

    private final PersonBussServiceIMPL serviceImpl;

    @PostMapping
    public ResponseEntity<PersonBussDto> createPersonBus(@RequestBody PersonBussDto personBussDTO) {
        return new ResponseEntity<>(serviceImpl.createPersonBus(personBussDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<PersonBussDto> findAllPersonsBus() {
        return serviceImpl.findAllPersonsBus();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<PersonBussDto>> findAllPersonByName(@PathVariable("name") String name){
        return new ResponseEntity<>(serviceImpl.findAllPersonByName(name), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<PersonBussDto>> findByEmail(@PathVariable("email") String email){
        return new ResponseEntity<>(Optional.ofNullable(serviceImpl.findByEmail(email)), HttpStatus.OK);
    }

    @GetMapping("/{personBussId}")
    public ResponseEntity<PersonBussDto> getPersonBusById(@PathVariable("personBussId") Long personBussId) {
        return new ResponseEntity<>(serviceImpl.getPersonBusById(personBussId), HttpStatus.OK);
    }

    @PutMapping("/{personBussId}")
    public ResponseEntity<PersonBussDto> updatePersonBus(@PathVariable("personBussId") Long personBussId, @RequestBody PersonBussDto personBussDTO) {
        return new ResponseEntity<>(serviceImpl.updatePersonBus(personBussId, personBussDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{personBussId}")
    public ResponseEntity<String> deletePersonBusById(@PathVariable("personBussId") Long personBussId) {
        serviceImpl.deletePersonBusById(personBussId);
        return new ResponseEntity<>("Person deleted Successfully", HttpStatus.OK);
    }

}