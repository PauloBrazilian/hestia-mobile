package hestia.ms_security.framework.adapters.out.persistence;

import hestia.ms_security.domain.model.TypePerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypePersonRepository extends JpaRepository<TypePerson, Long> {
}
