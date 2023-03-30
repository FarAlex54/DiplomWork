package com.example.api.controllers;

import com.example.api.models.Product;
import com.example.api.repositories.ProductRepository;
import com.example.api.util.ProductErrorResponse;
import com.example.api.util.ProductNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final ProductRepository productRepository;

    public ApiController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/info")
    public String getInfoApi(){
        return "Данное API предназначено для получения информации о товарах";
    }
    @GetMapping("/product")
    public List<Product> getProduct(){
        System.out.println(productRepository.findAll());
        return productRepository.findAll();
    }
    @GetMapping("/product/{id}")
    public Optional<Product> getProductId(@PathVariable("id") int id){
        Optional<Product> productOptional = productRepository.findById(id);
        return Optional.ofNullable(productOptional.orElseThrow(ProductNotFoundException::new));
//        return productOptional.orElseThrow(ProductNotFoundException::new);
    }
    @GetMapping("/product/delete/{id}")
    public String deleteProductId(@PathVariable("id") int id){
        productRepository.deleteById(id);
        return "Товар успешно удален";
    }
    @GetMapping("/product/add")
    public String addProduct(@RequestParam("name") String name,@RequestParam("price") float price){
        Product newProduct = new Product(name, price);
        productRepository.save(newProduct);
        return "Товар успешно добавлен";
    }
    public ResponseEntity<ProductErrorResponse> handlerException(ProductNotFoundException productNotFoundException){
        ProductErrorResponse productErrorResponse = new ProductErrorResponse("Не удалось найти товар по данному ID");
        return new ResponseEntity<>(response, HttpStatusCode.NOT_FOUND);
    }
}
