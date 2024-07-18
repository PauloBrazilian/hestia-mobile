package hestia.msStore.controller;

import hestia.msStore.model.Category;
import hestia.msStore.model.Product;
import hestia.msStore.service.CategoryServiceIMPL;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryServiceIMPL serviceIMPL;

    @GetMapping
    public ResponseEntity<List<Category>> findAllCategory() {
        return new ResponseEntity<>(serviceIMPL.findAllCategory(), HttpStatus.OK);
    }

    @GetMapping("/{categoryName}")
    public List<Product> findAllCategoryByName(@PathVariable String categoryName) {
        return serviceIMPL.findAllCategoryByName(categoryName);
    }

}