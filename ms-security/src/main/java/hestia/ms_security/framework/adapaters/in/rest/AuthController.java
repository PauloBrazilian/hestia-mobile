package hestia.ms_security.framework.adapaters.in.rest;

import hestia.ms_security.application.service.AuthServiceImpl;
import hestia.ms_security.domain.dto.in.LoginDto;
import hestia.ms_security.domain.dto.in.PersonResponse;
import hestia.ms_security.domain.dto.in.PersonBussDto;
import hestia.ms_security.domain.dto.in.PersonDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth2")
@AllArgsConstructor
public class AuthController {

    private final AuthServiceImpl authServiceImpl;

    @PostMapping("/login")
    public ResponseEntity<PersonResponse> login(@RequestBody LoginDto loginDto) {
        return new ResponseEntity<>(authServiceImpl.login(loginDto), HttpStatus.OK);
    }

    @PostMapping("/register/person")
    public ResponseEntity<PersonResponse> register(@RequestBody PersonDto personDto) {
        return new ResponseEntity<>(authServiceImpl.register(personDto), HttpStatus.CREATED);
    }

    @PostMapping("/register/personBus")
    public ResponseEntity<PersonResponse> registerBus(@RequestBody PersonBussDto personBusDto) {
        return new ResponseEntity<>(authServiceImpl.registerBus(personBusDto), HttpStatus.CREATED);
    }

}