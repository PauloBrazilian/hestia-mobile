package hestia.ms_security.application.service;

import hestia.ms_security.application.ports.out.PersonBusClient;
import hestia.ms_security.application.ports.out.PersonClient;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@AllArgsConstructor
@Service
public class CustomUserDetailServiceImpl implements UserDetailsService {

    private PersonBusClient busClient;
    private PersonClient personClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var person = personClient.findByEmail(username);
        var personBus = busClient.findByEmail(username);

        if (person.isPresent()) {
            return new org.springframework.security.core.userdetails.User(
                    person.get().email(), person.get().password(), new ArrayList<>());
        }

        if (personBus.isPresent()) {
            return new org.springframework.security.core.userdetails.User(
                    personBus.get().email(), personBus.get().password(), new ArrayList<>());
        }

        throw new RuntimeException("User not Found");
    }


}