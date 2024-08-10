package hestia.msStore.framework.adapaters.out;

import hestia.msStore.domain.model.Lista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaRepository extends JpaRepository<Lista, Long> {
}
