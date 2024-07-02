package hestia.ms_notification.framework.adapters.out.persistence;

import hestia.ms_notification.domain.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
