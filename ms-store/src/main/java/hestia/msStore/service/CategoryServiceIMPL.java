package hestia.msStore.service;

import hestia.msStore.config.ClassMapper;
import hestia.msStore.exeptions.ProductAPIException;
import hestia.msStore.exeptions.ResourceNotFoundException;
import hestia.msStore.model.Category;
import hestia.msStore.model.Product;
import hestia.msStore.payload.CategoryDto;
import hestia.msStore.repository.CategoryRepository;
import hestia.msStore.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@Service
public class CategoryServiceIMPL implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ClassMapper mapper;

    @Override
    public List<CategoryDto> findAllCategory() {
        return categoryRepository.findAll()
                .stream()
                .map(mapper::categoryToDto)
                .collect(toList());
    }

    @Override
    public List<Product> findAllCategoryByName(String categoryName) {
        var categoryList = categoryRepository.findAllByCategoryName(categoryName);

        if (categoryList.isEmpty()) {
            throw new ResourceNotFoundException("No categories found with name: " + categoryName);
        }

        List<Product> productDtoList = new ArrayList<>();

        for (Category category : categoryList) {
            List<Product> productList = getProductById(category);
            List<Product> categoryProductDtos = productList.stream().toList();

            productDtoList.addAll(categoryProductDtos);
        }

        return productDtoList;
    }


    @Override
    public List<Product> getProductById(Category category) {
        if (category != null) {
            List<Product> existingProducts = productRepository.findAllByCategory(category);
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