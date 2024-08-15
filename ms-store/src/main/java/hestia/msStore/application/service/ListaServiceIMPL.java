package hestia.msStore.application.service;

import hestia.msStore.application.ports.in.ListaService;
import hestia.msStore.application.ports.out.AuthClient;
import hestia.msStore.application.ports.out.PersonClient;
import hestia.msStore.domain.dto.in.ListaDto;
import hestia.msStore.domain.dto.in.ListaResponse;
import hestia.msStore.domain.dto.in.ProductDto;
import hestia.msStore.domain.dto.out.LoginDto;
import hestia.msStore.domain.dto.out.PersonResponse;
import hestia.msStore.domain.mapper.ClassMapper;
import hestia.msStore.domain.model.Product;
import hestia.msStore.framework.adapaters.out.ListaRepository;
import hestia.msStore.framework.adapaters.out.ProductRepository;
import hestia.msStore.framework.exeptions.ListaNotFoundException;
import hestia.msStore.framework.exeptions.ProductAPIException;
import hestia.msStore.framework.exeptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@Service
public class ListaServiceIMPL implements ListaService {

    private final AuthClient authClient;
    private final PersonClient personClient;
    private final ListaRepository listaRepository;
    private final ProductRepository productRepository;
    private final ClassMapper mapper;

    @Override
    public List<ListaDto> findAllListas() {
        return listaRepository.findAll()
                .stream()
                .map(mapper::listaToDto)
                .collect(toList());
    }

    @Override
    public ListaDto findListaById(Long listaId) {
        var lista = listaRepository.findById(listaId).orElseThrow(ProductAPIException::new);
        return mapper.listaToDto(lista);
    }

    @Override
    public List<ListaResponse> findbyListaComparator(Long listaId) {
        var searchListas = listaRepository.findById(listaId).orElseThrow(ListaNotFoundException::new);

        Map<String, ListaResponse> productGroups = new HashMap<>();

        for (Product product : searchListas.getProducts()) {
            var productName = product.getProductName();

            var listaResponse = new ListaResponse();
            listaResponse.setListaName(productName);
            var productResponse = mapper.responseToProduct(product);

            productResponse.setPrice(product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity())));
            productResponse.setQuantity(product.getQuantity());
            productResponse.setPersonBussName(product.getPersonBussName());

            listaResponse.setProducts(new ArrayList<>(List.of(productResponse)));
            productGroups.put(productName, listaResponse);
        }

        return new ArrayList<>(productGroups.values());
    }

    @Override
    @Transactional
    public ListaDto createLista(ListaDto listaDto) {
        var personResponseOpt = new PersonResponse(listaDto.getPersonName(), "", "secret");

        if (personResponseOpt.email().isEmpty()) {
            var lista = mapper.dtoToLista(listaDto);

            var personDto = personClient.findAllPersonByName(personResponseOpt.name());
            var onePerson = personDto.get(0);

            LoginDto loginDto = new LoginDto(onePerson.email(), onePerson.password());
            PersonResponse personResponse = getPerson(loginDto);

            lista.setPersonName(personResponse.name());
            var newLista = listaRepository.save(lista);
            return mapper.listaToDto(newLista);
        }

        throw new RuntimeException("Bad Request in the List");
    }


    @Override
    public ListaDto updateLista(Long listaId, ListaDto listaDto) {
        var existingList = listaRepository.findById(listaId).orElseThrow(
                () -> new ResourceNotFoundException("Lista", "id", listaId));

        var lista = mapper.listaToDto(existingList);
        mapper.updateListaToDto(lista, existingList);
        var savedLista = listaRepository.save(existingList);
        return mapper.listaToDto(savedLista);
    }

    @Override
    public ListaDto addProductsInLista(Long listaId, Long productId, ProductDto productDto) {
        var existingList = listaRepository.findById(listaId).orElseThrow(
                () -> new ResourceNotFoundException("Lista", "id", listaId));

        var searchProduct = productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Product", "id", productId));

        System.out.println("Quantidade recebida no DTO: " + productDto.getQuantity());

        searchProduct.setQuantity(productDto.getQuantity());
        existingList.getProducts().add(searchProduct);

        var savedLista = listaRepository.save(existingList);
        return mapper.listaToDto(savedLista);
    }


    @Override
    public void deleteListaById(Long listaId) {
        var existingList = listaRepository.findById(listaId).orElseThrow(
                () -> new ResourceNotFoundException("Lista", "id", listaId));

        listaRepository.deleteById(existingList.getListaId());
    }

    @Override
    public void deleteProductInLista(Long listaId, Long productId) {
        var existingList = listaRepository.findById(listaId).orElseThrow(
                () -> new ResourceNotFoundException("Lista", "id", listaId));

        Product searchProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));

        existingList.getProducts().remove(searchProduct);
        listaRepository.save(existingList);
    }


    private PersonResponse getPerson(LoginDto loginDto) {
        var personOpt = personClient.findByEmail(loginDto.email());

        if (personOpt.isPresent()) {
            var person = personOpt.get();
            if (Objects.equals(loginDto.password(), person.password())) {
                return new PersonResponse(person.name(), person.email(), "secret");
            }
        }
        throw new RuntimeException("Not found Person");
    }


}