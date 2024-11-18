package hestia.msStore.framework.adapaters.in;

import hestia.msStore.application.service.ProductServiceIMPL;
import hestia.msStore.domain.dto.in.ProductDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductsController {

    private ProductServiceIMPL serviceIMPL;

    @PostMapping("/creating")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(serviceIMPL.createProduct(productDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAllProducts() {
        return new ResponseEntity<>(serviceIMPL.findAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/comparator/{productName}")
    public ResponseEntity<List<ProductDto>> findProductsByName(@PathVariable(value = "productName") String productName) {
        return new ResponseEntity<>(serviceIMPL.findAllProductsComparator(productName), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable(value = "productId") Long productId, @RequestBody(required = false) ProductDto productDto) {
        var products = serviceIMPL.findProductById(productId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable(value = "productId") Long productId, @RequestBody @Valid ProductDto productDto) {
        return new ResponseEntity<>(serviceIMPL.updateProduct(productId, productDto), HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable(value = "productId") Long productId) {
        serviceIMPL.deleteProductById(productId);
        return new ResponseEntity<>("Product deleted Successfully", HttpStatus.OK);
    }

}