package com.example.product_service.controller;

import com.example.product_service.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {
    @GetMapping
    public List<Product> getAllProducts() {
        return Arrays.asList(
                new Product(1L, "Laptop", 1200.50),
                new Product(2L, "Smartphone", 750.99)
        );
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return new Product(id, "Sample Product", 100.0);
    }
}
