package hestia.msStore.framework.adapaters.in;

import hestia.msStore.application.service.CategoryServiceIMPL;
import hestia.msStore.domain.model.Category;
import hestia.msStore.domain.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
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