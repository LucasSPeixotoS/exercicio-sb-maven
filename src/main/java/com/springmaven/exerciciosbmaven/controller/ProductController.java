package com.springmaven.exerciciosbmaven.controller;

import com.springmaven.exerciciosbmaven.dto.ProductDTO;
import com.springmaven.exerciciosbmaven.model.entity.Product;
import com.springmaven.exerciciosbmaven.model.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public @ResponseBody ProductDTO newProduct(@Valid Product product){
        productRepository.save(product);
        return new ProductDTO(product.getName(), product.getPrice(), product.getDiscountPercentage());
    }

    @GetMapping
    public List<ProductDTO> getAllProduct(){
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> new ProductDTO(product.getName(), product.getPrice(), product.getDiscountPercentage()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{name}")
    public List<ProductDTO> findByNameContainingIgnoreCase(@PathVariable String name){
        List<Product> products = productRepository.findByNameContainingIgnoreCase(name);
        return products.stream()
                .map(product -> new ProductDTO(product.getName(), product.getPrice(), product.getDiscountPercentage()))
                .collect(Collectors.toList());
    }

}
