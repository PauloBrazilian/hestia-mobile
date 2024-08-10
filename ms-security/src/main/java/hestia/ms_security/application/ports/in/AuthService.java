package hestia.ms_security.application.ports.in;

import hestia.ms_security.domain.dto.LoginDto;
import hestia.ms_security.domain.dto.PersonResponse;
import hestia.ms_security.domain.dto.PersonBussDto;
import hestia.ms_security.domain.dto.PersonDto;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "ms-person", url = "http://localhost:8082")
public interface AuthService {

    PersonResponse login(LoginDto loginDto);

    PersonResponse register(PersonDto personDto);

    PersonResponse registerBus(PersonBussDto personBussDto);

}