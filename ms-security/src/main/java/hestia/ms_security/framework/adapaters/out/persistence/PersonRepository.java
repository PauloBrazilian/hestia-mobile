package hestia.ms_security.framework.adapaters.out.persistence;

import hestia.ms_security.domain.entity.PersonRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<PersonRole, Long> {

    Optional<PersonRole> findByEmail(String email);

}