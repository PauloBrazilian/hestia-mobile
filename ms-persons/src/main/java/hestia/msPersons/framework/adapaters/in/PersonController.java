package hestia.msPersons.framework.adapaters.in;

import hestia.msPersons.application.service.PersonServiceIMPL;
import hestia.msPersons.domain.dto.PersonDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonServiceIMPL serviceImpl;

    @PostMapping
    public ResponseEntity<PersonDto> createPerson(@RequestBody @Valid PersonDto personDTO) {
        return new ResponseEntity<>(serviceImpl.createPerson(personDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<PersonDto> findAllPersons() {
        return serviceImpl.findAllPersons();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<PersonDto>> findByEmail(@PathVariable("email") String email) {
        return new ResponseEntity<>(Optional.ofNullable(serviceImpl.findByEmail(email)), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<PersonDto>> findAllPersonByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(serviceImpl.findAllPersonByName(name), HttpStatus.OK);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<PersonDto> getPersonById(@PathVariable("personId") Long personId) {
        return new ResponseEntity<>(serviceImpl.getPersonById(personId), HttpStatus.OK);
    }

    @PutMapping("/{personId}")
    public ResponseEntity<PersonDto> updatePerson(@PathVariable("personId") Long personId, @RequestBody PersonDto personDTO) {
        return new ResponseEntity<>(serviceImpl.updatePerson(personId, personDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<String> deletePersonById(@PathVariable("personId") Long personId) {
        serviceImpl.deletePersonById(personId);
        return new ResponseEntity<>("Product deleted Successfully", HttpStatus.OK);
    }

}