package hestia.msStore.service;

import hestia.msStore.model.Lista;
import hestia.msStore.payload.ListaResponse;
import java.util.List;

public interface ListaService {

    public List<Lista> findAllListas();

    public List<Lista> findAllListaById(int listaId);

    public List<ListaResponse> findbyListaComparator(int listaId);

    public Lista createLista(Lista lista);

    public Lista updateLista(int listaId, Lista lista);

    public Lista addProductsInLista(int listaId, int productId);

    public void deleteListaById(int listaId);

    public void deleteProductInLista(int listaId, int productId);

}