package hestia.msStore.repository;

import hestia.msStore.model.Category;
import hestia.msStore.payload.CategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByCategoryName(String categoryName);
    List<Category> findAllByCategoryName(String categoryName);
}