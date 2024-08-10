package hestia.msStore.application.ports.out;

import hestia.msStore.domain.dto.out.LoginDto;
import hestia.msStore.domain.dto.out.PersonBussDto;
import hestia.msStore.domain.dto.out.PersonDto;
import hestia.msStore.domain.dto.out.PersonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-security", url = "http://localhost:8081", configuration = FeignClientProperties.FeignClientConfiguration.class)
public interface AuthClient {

    @PostMapping("/auth2/login")
    PersonResponse login(@RequestBody LoginDto loginDto);

    @PostMapping("/auth2/register/person")
    PersonResponse register(@RequestBody PersonDto personDto);

    @PostMapping("/auth2/register/personBus")
    PersonResponse registerBus(@RequestBody PersonBussDto personBusDto);

}