package hestia.msStore.service;

import hestia.msStore.model.Category;
import hestia.msStore.model.Product;
import hestia.msStore.payload.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<Category> findAllCategory();

    List<Product> findAllCategoryByName(String categoryName);

    List<Product> getProductById(Category category);

}