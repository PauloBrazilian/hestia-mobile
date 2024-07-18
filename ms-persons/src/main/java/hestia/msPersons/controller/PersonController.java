package hestia.msPersons.controller;

import hestia.msPersons.payload.PersonDto;
import hestia.msPersons.service.PersonServiceIMPL;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonServiceIMPL personUserServiceIMPL;

    @GetMapping
    public List<PersonDto> findAllPersons() {
        return personUserServiceIMPL.findAllPersons();
    }

    @PostMapping
    public ResponseEntity<PersonDto> createPerson(@RequestBody @Valid PersonDto personDTO) {
        return new ResponseEntity<>(personUserServiceIMPL.createPerson(personDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<PersonDto> getPersonById(@PathVariable("personId") int personId) {
        return new ResponseEntity<>(personUserServiceIMPL.getPersonById(personId), HttpStatus.OK);
    }

    @PutMapping("/{personId}")
    public ResponseEntity<PersonDto> updatePerson(@PathVariable("personId") int personId, @RequestBody PersonDto personDTO) {
        return new ResponseEntity<>(personUserServiceIMPL.updatePerson(personId, personDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<String> deletePersonById(@PathVariable("personId") int personId) {
        personUserServiceIMPL.deletePersonById(personId);
        return new ResponseEntity<>("Product deleted Successfully", HttpStatus.OK);
    }

}