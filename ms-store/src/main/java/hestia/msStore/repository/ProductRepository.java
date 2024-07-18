package hestia.msStore.repository;

import hestia.msStore.model.Category;
import hestia.msStore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByCategory(Category category);

}