package hestia.msStore.repository;

import hestia.msStore.model.Category;
import hestia.msStore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByProductName(String productName);
    List<Product> findAllByCategory(Category category);
    Product findByProductName(String productName);
}