package hestia.msPersons.controller;

import hestia.msPersons.entity.Person;
import hestia.msPersons.payload.PersonDTO;
import hestia.msPersons.service.PersonUserServiceIMPL;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonUserServiceIMPL personUserServiceIMPL;

    @Autowired
    public PersonController(PersonUserServiceIMPL personUserServiceIMPL) {
        this.personUserServiceIMPL = personUserServiceIMPL;
    }

    @GetMapping
    public List<PersonDTO> FindAllPersons(){
        return personUserServiceIMPL.FindAllPersons();
    }

    @PostMapping
    public ResponseEntity<PersonDTO> createPerson(@RequestBody @Valid PersonDTO personDTO){
        return new ResponseEntity<>(personUserServiceIMPL.createPerson(personDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable("personId") int personId){
        return new ResponseEntity<>(personUserServiceIMPL.getPersonById(personId), HttpStatus.OK);
    }

    @PutMapping("/{personId}")
    public ResponseEntity<PersonDTO> updatePerson(@PathVariable("personId") int personId, @RequestBody PersonDTO personDTO) {
        return new ResponseEntity<>(personUserServiceIMPL.updatePerson(personId, personDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<String> deletePersonById(@PathVariable("personId") int personId){
        personUserServiceIMPL.deletePersonById(personId);
        return new ResponseEntity<>("Product deleted Successfully", HttpStatus.OK);
    }


}