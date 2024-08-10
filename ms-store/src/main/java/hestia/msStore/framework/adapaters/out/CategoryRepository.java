package hestia.msStore.framework.adapaters.out;

import hestia.msStore.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByCategoryName(String categoryName);

    List<Category> findAllByCategoryName(String categoryName);
}