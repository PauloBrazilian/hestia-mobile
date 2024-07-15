package hestia.msStore.service;

import hestia.msStore.config.ClassMapper;
import hestia.msStore.exeptions.ResourceNotFoundException;
import hestia.msStore.model.Lista;
import hestia.msStore.model.Product;
import hestia.msStore.payload.ListaResponse;
import hestia.msStore.repository.ListaRepository;
import hestia.msStore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Service
public class ListaServiceIMPL implements ListaService {

    private final ListaRepository listaRepository;

    private final ProductRepository productRepository;

    private final ClassMapper mapper;


    @Autowired
    public ListaServiceIMPL(ListaRepository listaRepository, ProductRepository productRepository, ClassMapper mapper) {
        this.listaRepository = listaRepository;
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Lista> findAllListas() {
        return new ArrayList<>(listaRepository.findAll());
    }

    @Override
    public List<Lista> findAllListaById(int listaId) {
        var lista = listaRepository.findById(listaId);
        if (lista.isEmpty()) {
            throw new ResourceNotFoundException("No Lista found with name: " + listaId);
        }

        return lista.stream()
                .collect(toList());
    }

    @Override
    public List<ListaResponse> findbyListaComparator(int listaId) {
        var searchListas = listaRepository.findById(listaId).orElseThrow(
                () -> new ResourceNotFoundException("Lista", "id", listaId));

        Map<String, ListaResponse> productGroups = new HashMap<>();

        for (Product product : searchListas.getProducts()) {
            var productName = product.getProductName();

            if (productGroups.containsKey(productName)) {
                var listaResponse = productGroups.get(productName);
                var productResponse = mapper.responseToProduct(product);

                if (listaResponse.getProducts() == null) {
                    listaResponse.setProducts(new ArrayList<>());
                }

                BigDecimal calcullyPrice = product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity()));
                productResponse.setPrice(productResponse.getPrice().add(calcullyPrice));

                Integer calcullyQuantity = product.getQuantity();
                Integer finalQuantity = productResponse.getQuantity() + calcullyQuantity;
                productResponse.setQuantity(finalQuantity);

                listaResponse.getProducts().add(productResponse);
            } else {
                var listaResponse = new ListaResponse();
                listaResponse.setListaName(productName);
                var productResponse = mapper.responseToProduct(product);
                productResponse.setPrice(product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity())));
                productResponse.setQuantity(product.getQuantity());
                listaResponse.setProducts(new ArrayList<>(List.of(productResponse)));
                productGroups.put(productName, listaResponse);
            }
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

        existingList.setListaName(lista.getListaName());
        existingList.setData(lista.getData());
        return listaRepository.save(existingList);
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