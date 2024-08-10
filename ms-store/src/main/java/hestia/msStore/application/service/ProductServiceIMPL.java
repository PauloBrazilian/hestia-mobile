package hestia.msStore.application.service;

import hestia.msStore.application.ports.in.ProductsService;
import hestia.msStore.application.ports.out.PersonBusClient;
import hestia.msStore.domain.dto.in.ProductDto;
import hestia.msStore.domain.dto.out.LoginDto;
import hestia.msStore.domain.dto.out.PersonResponse;
import hestia.msStore.domain.mapper.ClassMapper;
import hestia.msStore.domain.model.Category;
import hestia.msStore.framework.adapaters.out.CategoryRepository;
import hestia.msStore.framework.adapaters.out.ProductRepository;
import hestia.msStore.framework.exeptions.ProductAPIException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@Service
public class ProductServiceIMPL implements ProductsService {

    private final PersonBusClient busClient;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ClassMapper mapper;

    @Override
    public List<ProductDto> findAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(mapper::productToDto)
                .collect(toList());
    }

    @Override
    public ProductDto findProductById(Long productId) {
        var product = productRepository.findById(productId).orElseThrow(ProductAPIException::new);
        return mapper.productToDto(product);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {

        var personResponseOpt = new PersonResponse(productDto.getPersonBussName(), "", "secret");

        if (personResponseOpt.email().isEmpty()) {
            var product = mapper.dtoToProduct(productDto);

            var personDto = busClient.findAllPersonByName(personResponseOpt.name());
            var onePerson = personDto.get(0);

            LoginDto loginDto = new LoginDto(onePerson.email(), onePerson.password());
            PersonResponse personResponse = getPerson(loginDto);
            product.setPersonBussName(personResponse.name());

            var categories = getCategoryByName(productDto.getCategories());
            product.setCategories(categories);

            var newProduct = productRepository.save(product);
            return mapper.productToDto(newProduct);
        }

        throw new RuntimeException("Bad Request in the List");
    }


    @Override
    public ProductDto updateProduct(Long productId, ProductDto productDto) {
        var searchProduct = productRepository.findById(productId).orElseThrow(ProductAPIException::new);
        var product = mapper.productToDto(searchProduct);
        mapper.updateProductToDto(product, searchProduct);
        var savedProduct = productRepository.save(searchProduct);
        return mapper.productToDto(savedProduct);
    }

    @Override
    public void deleteProductById(Long productId) {
        var product = productRepository.findById(productId).orElseThrow(ProductAPIException::new);
        productRepository.deleteById(product.getProductId());
    }


    private Category getCategoryByName(Category categories) {
        if (categories.getCategoryName() != null) {
            Optional<Category> existingCategory = categoryRepository.findByCategoryName(categories.getCategoryName());
            return existingCategory.orElseGet(() -> categoryRepository.save(categories));
        }
        throw new ProductAPIException(HttpStatus.BAD_REQUEST, "Category is Null or Invalid");
    }

    private PersonResponse getPerson(LoginDto loginDto) {
        var personOpt = busClient.findByEmail(loginDto.email());

        if (personOpt.isPresent()) {
            var person = personOpt.get();
            if (Objects.equals(loginDto.password(), person.password())) {
                return new PersonResponse(person.name(), person.email(), "secret");
            }
        }
        throw new RuntimeException("Not found Person");
    }

}