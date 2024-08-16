package hestia.msStore.framework.adapaters.out;

import hestia.msStore.domain.model.Lista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListaRepository extends JpaRepository<Lista, Long> {

    List<Lista> findAllByPersonName(String personName);

}
