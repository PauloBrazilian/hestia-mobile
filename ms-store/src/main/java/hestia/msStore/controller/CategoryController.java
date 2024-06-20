package hestia.msStore.controller;

import hestia.msStore.model.Product;
import hestia.msStore.service.CategoryServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryServiceIMPL serviceIMPL;

    @GetMapping("/{categoryName}")
    public List<Product> findAllCategoryByName(@PathVariable String categoryName) {
        return serviceIMPL.findAllCategoryByName(categoryName);
    }

}