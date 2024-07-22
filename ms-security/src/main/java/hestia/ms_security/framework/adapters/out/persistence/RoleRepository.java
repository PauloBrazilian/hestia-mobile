package hestia.ms_security.framework.adapters.out.persistence;

import hestia.ms_security.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
