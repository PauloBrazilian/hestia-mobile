package hestia.msStore.service;

import hestia.msStore.model.Category;
import hestia.msStore.model.Product;

import java.util.List;


public interface ProductsService {

    List<Product> findAllProducts();

    Product findProductById(int productId);

    Product createProduct(Product product);

    Product updateProduct(int productId, Product product);

    void deleteProductById(int productId);

    Category getCategoryById(Category category);
}