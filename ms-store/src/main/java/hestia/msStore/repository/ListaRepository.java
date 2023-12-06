package hestia.msStore.repository;

import hestia.msStore.model.Lista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ListaRepository extends JpaRepository<Lista, Integer> {
    Optional<Lista> findAllByListaName(String listaName);

//    List<Lista> findAllByProductInListaName(List<Lista> seachListas);
}
