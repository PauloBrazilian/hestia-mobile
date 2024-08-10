package hestia.msStore.application.ports.out;

import hestia.msStore.domain.dto.out.PersonBussDto;
import hestia.msStore.domain.dto.out.PersonDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "ms-persons-person-bus", url = "http://localhost:8082/", configuration = FeignClientProperties.FeignClientConfiguration.class)
public interface PersonBusClient {

//    @PostMapping("/personBus")
//    Person createPersonBus(@RequestBody PersonBussDto personBussDTO);
//
//    @GetMapping
//    PersonBussDto findAllPersonsBus();
//
//    @GetMapping(value = "/{personId}", produces = "application/json")
//    PersonBussDto getPersonBusById(@PathVariable("personBussId") Long personBussId);

    @GetMapping(value = "/personBus/email/{email}", produces = "application/json")
    Optional<PersonBussDto> findByEmail(@PathVariable("email") String email);

    @GetMapping(value = "/personBus/name/{name}", produces = "application/json")
    List<PersonBussDto> findAllPersonByName(@PathVariable("name") String name);

//    @PutMapping(value = "/{personId}", produces = "application/json")
//    PersonBussDto updatePersonBus(@PathVariable("personBussId") Long personBussId, @RequestBody PersonBussDto personBussDTO);
//
//    @DeleteMapping("/{personBussId}")
//    String deletePersonBusById(@PathVariable("personBussId") Long personBussId);

}