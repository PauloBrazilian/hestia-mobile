package hestia.ms_security.application.service;

import hestia.ms_security.application.ports.in.AuthService;
import hestia.ms_security.application.ports.out.NotificationClient;
import hestia.ms_security.application.ports.out.PersonBusClient;
import hestia.ms_security.application.ports.out.PersonClient;
import hestia.ms_security.application.ports.out.RoleClient;
import hestia.ms_security.domain.dto.in.*;
import hestia.ms_security.domain.dto.out.EmailDto;
import hestia.ms_security.domain.enums.AuthorizationEnum;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final NotificationClient notificationClient;
    private final PersonClient personClient;
    private final PersonBusClient busClient;
    private final RoleClient roleClient;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;


    @Override
    public PersonResponse login(LoginDto loginDto) {

        var personOpt = personClient.findByEmail(loginDto.email());
        var personBussOpt = busClient.findByEmail(loginDto.email());

        if (personOpt.isPresent()) {
            var person = personOpt.get();
            if (person.roleDto() == null) {
                var roleDto = roleClient.findByEmail(person.email());
                passwordEncoder.matches(loginDto.password(), person.password());

                var emailDto = new EmailDto();
                emailDto.setFromEmail("Contatoequipehestia@gmail.com");
                emailDto.setFromName(person.name());
                emailDto.setReplyTo(person.email());
                emailDto.setSubject("Welcome to the hestia");
                emailDto.setBody("<p>Welcome to the hestia</p>");
                notificationClient.emailWelcome(emailDto);

                return new PersonResponse(person.name(), person.email(), roleDto.token());
            }
        } else if (personBussOpt.isPresent()) {
            var personBuss = personBussOpt.get();
            var roleDto = roleClient.findByEmail(personBuss.email());
            passwordEncoder.matches(loginDto.password(), personBuss.password());

            var emailDto = new EmailDto();
            emailDto.setFromEmail("Contatoequipehestia@gmail.com");
            emailDto.setFromName(personBuss.name());
            emailDto.setReplyTo(personBuss.email());
            emailDto.setSubject("Welcome to the hestia");
            emailDto.setBody("<p>Welcome to the hestia</p>");
            notificationClient.emailWelcome(emailDto);

            return new PersonResponse(personBuss.name(), personBuss.email(), roleDto.token());
        }

        throw new RuntimeException("User not found or incorrect password");
    }


    @Override
    @Transactional
    public PersonResponse register(PersonDto personDto) {
        var searchPerson = personClient.findByEmail(personDto.email());

        if (searchPerson.isEmpty()) {

            String encodedPassword = passwordEncoder.encode(personDto.password());

            RoleDto role = new RoleDto(personDto.roleDto() != null ? personDto.roleDto().id() : null,
                    personDto.name(), personDto.email(), "Secret", AuthorizationEnum.USER);

            String token = tokenService.generateToken(role);

            RoleDto newRole = new RoleDto(role.id(), role.name(), role.email(), token, role.access());
            roleClient.createRole(newRole);

            PersonDto newPersonDto = new PersonDto(personDto.active(), personDto.name(), personDto.email(), encodedPassword, personDto.personImg(), newRole);
            personClient.createPerson(newPersonDto);
            return new PersonResponse(personDto.name(), personDto.email(), token);
        } else {
            throw new RuntimeException("Person already exists");
        }
    }


    @Override
    @Transactional
    public PersonResponse registerBus(PersonBussDto personBusDto) {
        var searchPerson = busClient.findByEmail(personBusDto.email());

        if (searchPerson.isEmpty()) {

            String encodedPassword = passwordEncoder.encode(personBusDto.password());

            RoleDto role = new RoleDto(personBusDto.roleDto() != null ? personBusDto.roleDto().id() : null,
                    personBusDto.name(), personBusDto.email(), "Secret", AuthorizationEnum.USER);

            String token = tokenService.generateToken(role);

            RoleDto newRole = new RoleDto(role.id(), role.name(), role.email(), token, role.access());
            roleClient.createRole(newRole);

            PersonBussDto newPersonBussDto = new PersonBussDto(personBusDto.active(), personBusDto.address(), personBusDto.city(),
                    personBusDto.cnpj(), personBusDto.district(), personBusDto.email(), personBusDto.name(), personBusDto.number(),
                    encodedPassword, personBusDto.personImg(), personBusDto.uf(), newRole);
            busClient.createPersonBus(newPersonBussDto);
            return new PersonResponse(personBusDto.name(), personBusDto.email(), token);
        } else {
            throw new RuntimeException("Person already exists");
        }
    }


}