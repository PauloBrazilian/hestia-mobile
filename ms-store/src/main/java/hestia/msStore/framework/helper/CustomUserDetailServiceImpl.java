package hestia.msStore.framework.helper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomUserDetailServiceImpl
//        implements UserDetailsService
{
//
//    private PersonBusClient busClient;
//    private PersonClient personClient;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        var person = personClient.findByEmail(username);
//        var personBus = busClient.findByEmail(username);
//
//        if (person.isPresent()) {
//            Set<GrantedAuthority> authorities = new HashSet<>();
//            if (person.get().roleDto() != null) {
//                authorities.add(new SimpleGrantedAuthority(person.get().roleDto().access().name()));
//            }
//
//            return new org.springframework.security.core.userdetails.User(
//                    person.get().email(), person.get().password(), authorities);
//        } else if (personBus.isPresent()) {
//            Set<GrantedAuthority> authorities = new HashSet<>();
//            if (personBus.get().roleDto() != null) {
//                authorities.add(new SimpleGrantedAuthority(personBus.get().roleDto().access().name()));
//            }
//
//            return new org.springframework.security.core.userdetails.User(
//                    personBus.get().email(), personBus.get().password(), authorities);
//        }
//
//        throw new UsernameNotFoundException("User not found with email: " + username);
//    }

}
