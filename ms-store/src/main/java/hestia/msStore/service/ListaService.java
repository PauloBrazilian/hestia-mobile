package hestia.msStore.service;

import hestia.msStore.model.Lista;
import hestia.msStore.payload.ListaResponse;
import java.util.List;

public interface ListaService {

    List<Lista> findAllListas();

    Lista findListaById(int listaId);

    List<ListaResponse> findbyListaComparator(int listaId);

    Lista createLista(Lista lista);

    Lista updateLista(int listaId, Lista lista);

    Lista addProductsInLista(int listaId, int productId);

    void deleteListaById(int listaId);

    void deleteProductInLista(int listaId, int productId);

}