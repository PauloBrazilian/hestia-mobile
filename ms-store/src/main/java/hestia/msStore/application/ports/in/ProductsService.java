package hestia.msStore.application.ports.in;

import hestia.msStore.domain.dto.in.ProductDto;

import java.util.List;


public interface ProductsService {

    List<ProductDto> findAllProducts();

    List<ProductDto> findAllProductsComparator(String productName);

    ProductDto findProductById(Long productId);

    ProductDto createProduct(ProductDto productDto);

    ProductDto updateProduct(Long productId, ProductDto productDto);

    void deleteProductById(Long productId);

}