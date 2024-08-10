package hestia.msStore.application.ports.in;

import hestia.msStore.domain.model.Category;
import hestia.msStore.domain.model.Product;

import java.util.List;

public interface CategoryService {

    List<Category> findAllCategory();

    List<Product> findAllCategoryByName(String categoryName);

    List<Product> getProductById(Category category);

}