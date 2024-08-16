package hestia.msPersons.framework.adapaters.out;

import hestia.msPersons.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRespository extends JpaRepository<Role, Long> {

    Role findByEmail(String email);

}
