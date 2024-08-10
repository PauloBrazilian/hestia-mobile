package hestia.msPersons.framework.adapaters.out;


import hestia.msPersons.domain.entity.Person;
import hestia.msPersons.domain.entity.PersonBUSS;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface PersonBussRepository extends JpaRepository<PersonBUSS, Long> {

    PersonBUSS findByEmail(String login);

    List<PersonBUSS> findAllPersonByName(String name);

}
