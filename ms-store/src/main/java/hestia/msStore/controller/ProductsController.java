package hestia.msStore.controller;


import hestia.msStore.model.Product;
import hestia.msStore.payload.ProductDto;
import hestia.msStore.service.ProductServiceIMPL;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductServiceIMPL serviceIMPL;

    @PostMapping("/creating")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(serviceIMPL.createProduct(productDto), HttpStatus.CREATED);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<List<Product>> findAllProductById(@PathVariable(value = "productId") int productId, @RequestBody(required = false) ProductDto productDto) {
        List<Product> products = serviceIMPL.findAllProductById(productId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAllProducts() {
        return new ResponseEntity<>(serviceIMPL.findAllProducts(), HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable(value = "productId") int productId){
        serviceIMPL.deleteProductById(productId);
        return new ResponseEntity<>("Product deleted Successfully",HttpStatus.OK);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable(value = "productId") int productId, @RequestBody @Valid ProductDto productDto){
        return new ResponseEntity<>(serviceIMPL.updateProduct(productId,productDto),HttpStatus.OK);
    }



}