package com.springmaven.exerciciosbmaven.controller;

import com.springmaven.exerciciosbmaven.model.entity.Product;
import com.springmaven.exerciciosbmaven.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Product newProduct(@RequestParam String name){
        Product product = new Product(name);
        productRepository.save(product);
        return new Product(name);
    }

}
