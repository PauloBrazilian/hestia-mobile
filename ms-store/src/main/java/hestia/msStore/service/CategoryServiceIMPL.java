package hestia.msStore.service;

import hestia.msStore.config.ClassMapper;
import hestia.msStore.exeptions.ProductAPIException;
import hestia.msStore.exeptions.ResourceNotFoundException;
import hestia.msStore.model.Category;
import hestia.msStore.model.Product;
import hestia.msStore.payload.ProductDto;
import hestia.msStore.repository.CategoryRepository;
import hestia.msStore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceIMPL implements CategoryService{

    private final CategoryRepository categoryRepository;

    private final ProductRepository productRepository;

    @Autowired
    public CategoryServiceIMPL(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> findAllCategoryByName(String categoryName) {
        List<Category> categoryList = categoryRepository.findAllByCategoryName(categoryName);

        if (categoryList.isEmpty()) {
            throw new ResourceNotFoundException("No categories found with name: " + categoryName);
        }

        List<ProductDto> productDtoList = new ArrayList<>();

        for (Category category : categoryList) {
            List<Product> productList = getProductyById(category);
            List<ProductDto> categoryProductDtos = productList.stream()
                    .map(ClassMapper.INTANCE::productToDto)
                    .toList();

            productDtoList.addAll(categoryProductDtos);
        }

        return productDtoList;
    }


    @Override
    public List<Product> getProductyById(Category category) {
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