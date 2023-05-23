package com.rest.templateguide.springbootresttemplate.controller;

import com.rest.templateguide.springbootresttemplate.model.Product;
import com.rest.templateguide.springbootresttemplate.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> viewProduct(){
        return ResponseEntity.ok(productService.viewAllProduct());
    }

    @PostMapping("/add/product")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return new ResponseEntity<>("Created successfully.", HttpStatus.OK);
    }
}
