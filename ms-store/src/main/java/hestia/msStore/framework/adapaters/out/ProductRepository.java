package hestia.msStore.framework.adapaters.out;

import hestia.msStore.domain.model.Category;
import hestia.msStore.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCategories(Category categories);

}