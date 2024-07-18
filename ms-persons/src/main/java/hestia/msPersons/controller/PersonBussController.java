package hestia.msPersons.controller;

import hestia.msPersons.payload.PersonBussDto;
import hestia.msPersons.service.PersonBussServiceIMPL;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/personBus")
public class PersonBussController {

    private PersonBussServiceIMPL serviceIMP;

    @GetMapping
    public List<PersonBussDto> findAllPersonsBus() {
        return serviceIMP.findAllPersonsBus();
    }

    @PostMapping
    public ResponseEntity<PersonBussDto> createPersonBus(@RequestBody PersonBussDto personBussDTO) {
        return new ResponseEntity<>(serviceIMP.createPersonBus(personBussDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{personBussId}")
    public ResponseEntity<PersonBussDto> getPersonBusById(@PathVariable("personBussId") int personBussId) {
        return new ResponseEntity<>(serviceIMP.getPersonBusById(personBussId), HttpStatus.OK);
    }

    @PutMapping("/{personBussId}")
    public ResponseEntity<PersonBussDto> updatePersonBus(@PathVariable("personBussId") int personBussId, @RequestBody PersonBussDto personBussDTO) {
        return new ResponseEntity<>(serviceIMP.updatePersonBus(personBussId, personBussDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{personBussId}")
    public ResponseEntity<String> deletePersonBusById(@PathVariable("personBussId") int personBussId) {
        serviceIMP.deletePersonBusById(personBussId);
        return new ResponseEntity<>("Person deleted Successfully", HttpStatus.OK);
    }
}