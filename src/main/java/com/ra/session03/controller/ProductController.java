package com.ra.session03.controller;

import com.ra.session03.model.dto.DataResponse;
import com.ra.session03.model.entity.Product;
import com.ra.session03.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;
    @GetMapping
    public ResponseEntity<DataResponse> getAllProducts() {
        return new ResponseEntity<>(new DataResponse(productService.getAllProducts(), HttpStatus.OK), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DataResponse> getProductById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(new DataResponse(productService.getProductById(id), HttpStatus.OK), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<DataResponse> addCategory(@RequestBody Product product) {
        Product c =productService.saveProduct(product);
        return new ResponseEntity<>(new DataResponse(c, HttpStatus.CREATED), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DataResponse> updateCategory(@RequestBody Product product, @PathVariable("id") Integer id) {
        product.setId(id);
        Product c = productService.saveProduct(product);
        return new ResponseEntity<>(new DataResponse(c, HttpStatus.OK), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Integer id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
