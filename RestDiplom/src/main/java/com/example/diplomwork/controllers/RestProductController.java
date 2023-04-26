package com.example.diplomwork.controllers;

import com.example.diplomwork.repositories.ProductRepository;
import com.example.diplomwork.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestProductController {
    private final ProductRepository productRepository;
    private final ProductService productService;
    public RestProductController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

}