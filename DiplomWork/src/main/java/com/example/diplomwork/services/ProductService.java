package com.example.diplomwork.services;

import com.example.diplomwork.models.Category;
import com.example.diplomwork.models.Person;
import com.example.diplomwork.models.Product;
import com.example.diplomwork.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    public Product getProductId(int id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }
    @Transactional
    public void saveProduct(Product product, Category category){
        product.setCategory(category);
        productRepository.save(product);
    }
    @Transactional
    public void updateProduct(int id, Product product){
        product.setId(id);
        productRepository.save(product);
    }
    @Transactional
    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }



}
