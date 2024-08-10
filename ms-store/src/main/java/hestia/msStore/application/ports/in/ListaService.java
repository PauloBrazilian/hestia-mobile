package hestia.msStore.application.ports.in;

import hestia.msStore.domain.dto.in.ListaDto;
import hestia.msStore.domain.model.Lista;
import hestia.msStore.domain.dto.in.ListaResponse;

import java.util.List;

public interface ListaService {

    List<ListaDto> findAllListas();

    ListaDto findListaById(Long listaId);

    List<ListaResponse> findbyListaComparator(Long listaId);

    ListaDto createLista(ListaDto listaDto);

    ListaDto updateLista(Long listaId, ListaDto listaDto);

    ListaDto addProductsInLista(Long listaId, Long productId);

    void deleteListaById(Long listaId);

    void deleteProductInLista(Long listaId, Long productId);

}