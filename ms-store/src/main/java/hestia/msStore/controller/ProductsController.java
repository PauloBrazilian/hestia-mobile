package hestia.msStore.controller;


import hestia.msStore.model.Product;
import hestia.msStore.payload.ProductDto;
import hestia.msStore.service.ProductServiceIMPL;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductsController {

    private ProductServiceIMPL serviceIMPL;

    @PostMapping("/creating")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(serviceIMPL.createProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> findProductById(@PathVariable(value = "productId") int productId, @RequestBody(required = false) ProductDto productDto) {
        var products = serviceIMPL.findProductById(productId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts() {
        return new ResponseEntity<>(serviceIMPL.findAllProducts(), HttpStatus.OK);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "productId") int productId, @RequestBody @Valid Product product) {
        return new ResponseEntity<>(serviceIMPL.updateProduct(productId, product), HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable(value = "productId") int productId) {
        serviceIMPL.deleteProductById(productId);
        return new ResponseEntity<>("Product deleted Successfully", HttpStatus.OK);
    }

}