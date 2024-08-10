package hestia.ms_security.application.ports.out;

import hestia.ms_security.domain.dto.PersonDto;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@FeignClient(value = "ms-persons-person", url = "http://localhost:8082/", configuration = FeignClientProperties.FeignClientConfiguration.class)
public interface PersonClient {

    @PostMapping("/person")
    PersonDto createPerson(@RequestBody @Valid PersonDto personDTO);

    @GetMapping("/person")
    List<PersonDto> findAllPersons();

    @GetMapping(value = "/{personId}", produces = "application/json")
    PersonDto getPersonById(@PathVariable("personId") Long personId);

    @GetMapping(value = "/person/email/{email}", produces = "application/json")
    Optional<PersonDto> findByEmail(@PathVariable("email") String email);

//
//    @PutMapping(value = "/{personId}", produces = "application/json")
//    PersonDto updatePerson(@PathVariable("personId") Long personId, @RequestBody PersonDto personDTO);
//
//    @DeleteMapping(value = "/{personId}", produces = "application/json")
//    String deletePersonById(@PathVariable("personId") Long personId);

}
