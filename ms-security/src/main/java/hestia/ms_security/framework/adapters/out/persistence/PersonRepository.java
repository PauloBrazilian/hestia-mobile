package hestia.ms_security.framework.adapters.out.persistence;

import hestia.ms_security.domain.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
