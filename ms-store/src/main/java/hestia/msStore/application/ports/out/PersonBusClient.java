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

    @GetMapping(value = "/personBus/email/{email}", produces = "application/json")
    Optional<PersonBussDto> findByEmail(@PathVariable("email") String email);

    @GetMapping(value = "/personBus/name/{name}", produces = "application/json")
    List<PersonBussDto> findAllPersonByName(@PathVariable("name") String name);

}