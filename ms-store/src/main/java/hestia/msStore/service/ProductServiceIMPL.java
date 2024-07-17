package hestia.msStore.service;

import hestia.msStore.config.ClassMapper;
import hestia.msStore.exeptions.ProductAPIException;
import hestia.msStore.model.Category;
import hestia.msStore.model.Product;
import hestia.msStore.repository.CategoryRepository;
import hestia.msStore.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductServiceIMPL implements ProductsService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ClassMapper mapper;

    @Override
    public List<Product> findAllProducts() {
        return new ArrayList<>(productRepository.findAll());
    }

    @Override
    public Product findProductById(int productId) {
        return productRepository.findById(productId).orElseThrow(ProductAPIException::new);
    }

    @Override
    public Product createProduct(Product product) {
        var newProduct = Product.builder()
                .productName(product.getProductName())
                .description(product.getDescription())
                .imgUrl(product.getImgUrl())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .category(getCategoryById(product.getCategory()))
                .build();

        return productRepository.save(newProduct);
    }


    @Override
    public Product updateProduct(int productId, Product product) {
        var searchProduct = productRepository.findById(productId).orElseThrow(ProductAPIException::new);
        var productDto = mapper.productToDto(searchProduct);
        return productRepository.save(mapper.dtoToProduct(productDto));
    }

    @Override
    public void deleteProductById(int productId) {
        var product = productRepository.findById(productId).orElseThrow(ProductAPIException::new);
        productRepository.deleteById(product.getProductId());
    }

    @Override
    public Category getCategoryById(Category category) {
        if (category != null) {
            Optional<Category> existingCategory = categoryRepository.findByCategoryName(category.getCategoryName());
            return existingCategory.orElseGet(() -> categoryRepository.save(category));
        } else {
            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "Category is Null");
        }
    }

}