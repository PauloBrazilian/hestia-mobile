package hestia.msStore.service;

import hestia.msStore.model.Category;
import hestia.msStore.model.Product;
import hestia.msStore.payload.ProductDto;

import java.util.List;


public interface ProductsService {

    public List<ProductDto> findAllProducts();

    public List<Product> findAllProductById(int productId);

    public ProductDto createProduct(ProductDto productDto);

    public ProductDto updateProduct(int productId, ProductDto productDto);

    public void deleteProductById(int productId);

    public Category getCategoryById(Category category);
}