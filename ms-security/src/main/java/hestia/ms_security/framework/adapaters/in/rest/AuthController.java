package hestia.ms_security.framework.adapaters.in.rest;

import hestia.ms_security.domain.dto.LoginDto;
import hestia.ms_security.domain.dto.PersonResponse;
import hestia.ms_security.domain.dto.RegisterPersonBusRequestDto;
import hestia.ms_security.domain.dto.RegisterPersonRequestDto;
import hestia.ms_security.domain.entity.PersonRole;
import hestia.ms_security.framework.adapaters.out.persistence.PersonRepository;
import hestia.ms_security.framework.helper.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final PersonRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDto body) {
        var personRole = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(body.password(), personRole.getPassword())) {
            String token = this.tokenService.generateToken(personRole);
            return ResponseEntity.ok(new PersonResponse(personRole.getName(), token));
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register/person")
    public ResponseEntity register(@RequestBody RegisterPersonRequestDto body) {
        Optional<PersonRole> searchPerson = this.repository.findByEmail(body.email());

        if (searchPerson.isEmpty()) {
            var newPerson = new PersonRole();
            newPerson.setPassword(passwordEncoder.encode(body.password()));
            newPerson.setEmail(body.email());
            newPerson.setName(body.name());
            this.repository.save(newPerson);

            String token = this.tokenService.generateToken(newPerson);
            return ResponseEntity.ok(new PersonResponse(newPerson.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register/personBus")
    public ResponseEntity registerBus(@RequestBody RegisterPersonBusRequestDto body) {
        Optional<PersonRole> searchPerson = this.repository.findByEmail(body.email());

        if (searchPerson.isEmpty()) {
            var newPerson = new PersonRole();
            newPerson.setPassword(passwordEncoder.encode(body.password()));
            newPerson.setEmail(body.email());
            newPerson.setName(body.name());
            this.repository.save(newPerson);

            String token = this.tokenService.generateToken(newPerson);
            return ResponseEntity.ok(new PersonResponse(newPerson.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }

}