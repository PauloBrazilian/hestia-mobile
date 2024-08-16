package hestia.ms_security.application.ports.out;

import hestia.ms_security.domain.dto.in.PersonBussDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "ms-persons-person-bus", url = "http://localhost:8082/", configuration = FeignClientProperties.FeignClientConfiguration.class)
public interface PersonBusClient {

    @PostMapping("/personBus")
    PersonBussDto createPersonBus(@RequestBody PersonBussDto personBussDTO);

    @GetMapping("/personBus")
    List<PersonBussDto> findAllPersonsBus();

    @GetMapping(value = "/personBus/email/{email}", produces = "application/json")
    Optional<PersonBussDto> findByEmail(@PathVariable("email") String email);

}