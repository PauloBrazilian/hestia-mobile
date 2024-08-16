package hestia.msStore.application.ports.out;

import hestia.msStore.domain.dto.out.PersonDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@FeignClient(value = "ms-persons-person", url = "http://localhost:8082/", configuration = FeignClientProperties.FeignClientConfiguration.class)
public interface PersonClient {

    @GetMapping(value = "/{personId}", produces = "application/json")
    PersonDto getPersonById(@PathVariable("personId") Long personId);

    @GetMapping(value = "/person/email/{email}", produces = "application/json")
    Optional<PersonDto> findByEmail(@PathVariable("email") String email);

    @GetMapping(value = "/person/name/{name}", produces = "application/json")
    List<PersonDto> findAllPersonByName(@PathVariable("name") String name);

}
