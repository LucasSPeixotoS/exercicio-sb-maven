package com.springmaven.exerciciosbmaven.controller;

import com.springmaven.exerciciosbmaven.model.entity.Product;
import com.springmaven.exerciciosbmaven.model.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public @ResponseBody Product newProduct(@Valid Product product){
        productRepository.save(product);
        return product;
    }

}
