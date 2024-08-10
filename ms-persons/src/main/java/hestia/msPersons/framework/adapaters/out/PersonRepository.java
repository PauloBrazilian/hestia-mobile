package hestia.msPersons.framework.adapaters.out;


import hestia.msPersons.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByEmail(String login);

    List<Person> findAllPersonByName(String name);
}