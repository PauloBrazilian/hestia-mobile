package hestia.msStore.service;

import hestia.msStore.config.ClassMapper;
import hestia.msStore.exeptions.ListaNotFoundException;
import hestia.msStore.exeptions.ProductAPIException;
import hestia.msStore.exeptions.ResourceNotFoundException;
import hestia.msStore.model.Lista;
import hestia.msStore.model.Product;
import hestia.msStore.payload.ListaResponse;
import hestia.msStore.repository.ListaRepository;
import hestia.msStore.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class ListaServiceIMPL implements ListaService {

    private final ListaRepository listaRepository;
    private final ProductRepository productRepository;
    private final ClassMapper mapper;

    @Override
    public List<Lista> findAllListas() {
        return new ArrayList<>(listaRepository.findAll());
    }

    @Override
    public Lista findListaById(int listaId) {
        return listaRepository.findById(listaId).orElseThrow(ProductAPIException::new);
    }

    @Override
    public List<ListaResponse> findbyListaComparator(int listaId) {
        var searchListas = listaRepository.findById(listaId).orElseThrow(ListaNotFoundException::new);

        Map<String, ListaResponse> productGroups = new HashMap<>();

        for (Product product : searchListas.getProducts()) {
            var productName = product.getProductName();

            var listaResponse = new ListaResponse();
            listaResponse.setListaName(productName);
            var productResponse = mapper.responseToProduct(product);

            productResponse.setPrice(product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity())));
            productResponse.setQuantity(product.getQuantity());
            listaResponse.setProducts(new ArrayList<>(List.of(productResponse)));
            productGroups.put(productName, listaResponse);
        }

        return new ArrayList<>(productGroups.values());
    }

    @Override
    public Lista createLista(Lista lista) {
        Lista newLista = Lista.builder()
                .listaName(lista.getListaName())
                .data(lista.getData())
                .products(lista.getProducts())
                .build();
        return listaRepository.save(newLista);
    }


    @Override
    public Lista updateLista(int listaId, Lista lista) {
        var existingList = listaRepository.findById(listaId).orElseThrow(
                () -> new ResourceNotFoundException("Lista", "id", listaId));

        var listaDto = mapper.listaToDto(existingList);
        return listaRepository.save(mapper.dtoToLista(listaDto));
    }

    @Override
    public Lista addProductsInLista(int listaId, int productId) {
        var existingList = listaRepository.findById(listaId).orElseThrow(
                () -> new ResourceNotFoundException("Lista", "id", listaId));

        var searchProduct = productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Product", "id", productId));

        existingList.getProducts().add(searchProduct);
        return listaRepository.save(existingList);
    }


    @Override
    public void deleteListaById(int listaId) {
        var existingList = listaRepository.findById(listaId).orElseThrow(
                () -> new ResourceNotFoundException("Lista", "id", listaId));

        listaRepository.deleteById(existingList.getListaId());
    }

    @Override
    public void deleteProductInLista(int listaId, int productId) {
        var existingList = listaRepository.findById(listaId).orElseThrow(
                () -> new ResourceNotFoundException("Lista", "id", listaId));

        Product searchProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));

        existingList.getProducts().remove(searchProduct);
        listaRepository.save(existingList);
    }
}