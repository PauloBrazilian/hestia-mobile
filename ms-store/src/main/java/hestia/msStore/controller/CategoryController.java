package hestia.msStore.controller;

import hestia.msStore.payload.ProductDto;
import hestia.msStore.repository.CategoryRepository;
import hestia.msStore.service.CategoryServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryServiceIMPL serviceIMPL;
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryServiceIMPL serviceIMPL, CategoryRepository categoryRepository) {
        this.serviceIMPL = serviceIMPL;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/{categoryName}")
    public List<ProductDto> findAllCategoryByName(@PathVariable String categoryName) {
        return serviceIMPL.findAllCategoryByName(categoryName);
    }

}