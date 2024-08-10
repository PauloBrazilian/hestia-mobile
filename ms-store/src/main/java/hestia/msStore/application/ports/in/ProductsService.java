package hestia.msStore.application.ports.in;

import hestia.msStore.domain.dto.in.ProductDto;
import hestia.msStore.domain.model.Category;
import hestia.msStore.domain.model.Product;

import java.util.List;


public interface ProductsService {

    List<ProductDto> findAllProducts();

    ProductDto findProductById(Long productId);

    ProductDto createProduct(ProductDto product);

    ProductDto updateProduct(Long productId, ProductDto productDto);

    void deleteProductById(Long productId);

//    Category getCategoryById(Category category);
}