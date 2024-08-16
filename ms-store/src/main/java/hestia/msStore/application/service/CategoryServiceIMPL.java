package hestia.msStore.application.service;

import hestia.msStore.application.ports.in.CategoryService;
import hestia.msStore.domain.model.Category;
import hestia.msStore.domain.model.Product;
import hestia.msStore.framework.adapaters.out.CategoryRepository;
import hestia.msStore.framework.adapaters.out.ProductRepository;
import hestia.msStore.framework.exeptions.ProductAPIException;
import hestia.msStore.framework.exeptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CategoryServiceIMPL implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Override
    public List<Category> findAllCategory() {
        return new ArrayList<>(categoryRepository.findAll());
    }

    @Override
    public List<Product> findAllCategoryByName(String categoryName) {
        var categoryList = categoryRepository.findAllByCategoryName(categoryName);

        if (categoryList.isEmpty()) {
            throw new ResourceNotFoundException("No categories found with name: " + categoryName);
        }

        List<Product> productDtoList = new ArrayList<>();

        for (Category categories : categoryList) {
            List<Product> productList = getProductById(categories);
            List<Product> categoryProductDtos = productList.stream().toList();

            productDtoList.addAll(categoryProductDtos);
        }

        return productDtoList;
    }


    @Override
    public List<Product> getProductById(Category categories) {
        if (categories != null) {
            List<Product> existingProducts = productRepository.findAllByCategories(categories);
            if (!existingProducts.isEmpty()) {
                return existingProducts;
            } else {
                throw new ProductAPIException(HttpStatus.BAD_REQUEST, "No products found for the specified category");
            }
        } else {
            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "Category is Null");
        }
    }


}