package hestia.msStore.service;

import hestia.msStore.model.Category;
import hestia.msStore.model.Product;
import hestia.msStore.payload.ProductDto;

import java.util.List;

public interface CategoryService {

    public List<ProductDto> findAllCategoryByName(String categoryName);

    public List<Product> getProductyById(Category category);


}