package hestia.msStore.service;

import hestia.msStore.model.Category;
import hestia.msStore.model.Product;

import java.util.List;


public interface ProductsService {

    public List<Product> findAllProducts();

    public List<Product> findAllProductById(int productId);

    public Product createProduct(Product product);

    public Product updateProduct(int productId, Product product);

    public void deleteProductById(int productId);

    public Category getCategoryById(Category category);
}