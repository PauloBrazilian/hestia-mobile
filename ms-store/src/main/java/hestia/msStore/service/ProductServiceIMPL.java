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

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceIMPL implements ProductsService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ClassMapper mapper;

    @Autowired
    public ProductServiceIMPL(ProductRepository productRepository, CategoryRepository categoryRepository, ClassMapper mapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ProductDto> findAllProducts(){
        return productRepository.findAll()
                .stream()
                .map(product -> ClassMapper.INTANCE.productToDto(product))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findAllProductByName(String productName) {
        List<Product> products = productRepository.findAllByProductName(productName);

        if (products.isEmpty()) {
            throw new ResourceNotFoundException("No products found with name: " + productName);
        }

        return products.stream()
                .map(ClassMapper.INTANCE::productToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        var product = ClassMapper.INTANCE.dtoToProduct(productDto);
        var categories = getCategoryById(productDto.getCategories());
        product.setCategory(categories);
        productRepository.save(product);
        return ClassMapper.INTANCE.productToDto(product);
    }


    @Override
    public ProductDto updateProduct(int productId, ProductDto productDto) {
        var search = productRepository.findById(productId);

        if (search.isPresent()) {
            var product = ClassMapper.INTANCE.dtoToProduct(productDto);
            var categories = getCategoryById(productDto.getCategories());
            product.setCategory(categories);
            productRepository.save(product);
            return ClassMapper.INTANCE.productToDto(product);
        } else {
            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "Product not found");
        }
    }

    @Override
    public void deleteProductById(int productId) {
        var search = productRepository.findById(productId);

        if (search.isPresent()){
            productRepository.deleteById(productId);
        }else {
            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "Product not Exist");
        }

    }


    @Override
    public Category getCategoryById(Category category) {
        if (category != null) {
            Optional<Category> existingCategory = categoryRepository.findByCategoryName(category.getCategoryName());
            if (existingCategory.isPresent()) {
                return existingCategory.get();
            } else {
                return categoryRepository.save(category);
            }
        } else {
            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "Category is Null");
        }
    }

}