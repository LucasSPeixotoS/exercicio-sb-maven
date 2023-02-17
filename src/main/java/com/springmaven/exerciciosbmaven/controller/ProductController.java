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

    /*
    Esse método Post é igual o Put, poderia usar ele passando @RequestMapping(method = {RequestMethod.POST,
    RequestMethod.Put}) que iria fazer a função do Post quando usar Post e Put quando usar put.
    */
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

    @PutMapping
    public Product alterProduct(@Valid Product product){
        productRepository.save(product);
        return product;
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable int id){
        productRepository.deleteById(id);
        return "Successfully deleted.";
    }

}
