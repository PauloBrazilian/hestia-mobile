package hestia.msPersons.controller;

import hestia.msPersons.entity.PersonBUSS;
import hestia.msPersons.payload.PersonBussDTO;
import hestia.msPersons.payload.PersonDTO;
import hestia.msPersons.service.PersonBussServiceIMPL;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/personBus")
public class PersonBussController {

    private PersonBussServiceIMPL serviceIMP;

    @Autowired
    public PersonBussController(PersonBussServiceIMPL serviceIMP) {
        this.serviceIMP = serviceIMP;
    }

    @GetMapping
    public List<PersonBussDTO> FindAllPersonsBus(){
       return serviceIMP.FindAllPersonsBus();
    }

    @PostMapping
    public ResponseEntity<PersonBussDTO> createPersonBus(@RequestBody PersonBussDTO personBussDTO) {
        return new ResponseEntity<>(serviceIMP.createPersonBus(personBussDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{personBussId}")
    public ResponseEntity<PersonBussDTO> getPersonBusById(@PathVariable("personBussId") int personBussId){
        return new ResponseEntity<>(serviceIMP.getPersonBusById(personBussId), HttpStatus.OK);
    }

    @PutMapping("/{personBussId}")
    public ResponseEntity<PersonBussDTO> updatePersonBus(@PathVariable("personBussId") int personBussId, @RequestBody PersonBussDTO personBussDTO){
        return new ResponseEntity<>(serviceIMP.updatePersonBus(personBussId, personBussDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{personBussId}")
    public ResponseEntity<String> deletePersonBusById(@PathVariable("personBussId") int personBussId){
        serviceIMP.deletePersonBusById(personBussId);
        return new ResponseEntity<>("Person deleted Successfully", HttpStatus.OK);
    }
}