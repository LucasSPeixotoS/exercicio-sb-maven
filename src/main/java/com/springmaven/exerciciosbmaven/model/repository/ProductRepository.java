package com.springmaven.exerciciosbmaven.model.repository;

import com.springmaven.exerciciosbmaven.model.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findAll();

    List<Product> findByNameContainingIgnoreCase(String name);

}
