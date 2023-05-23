package com.rest.templateguide.springbootresttemplate.service;

import com.rest.templateguide.springbootresttemplate.model.Product;
import com.rest.templateguide.springbootresttemplate.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    public List<Product> viewAllProduct(){
        List<Product> products = productRepository.findAll();
        return products;
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }
}
