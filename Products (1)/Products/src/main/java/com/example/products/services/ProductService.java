package com.example.products.services;

import com.example.products.models.Product;
import com.example.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional(readOnly = true)
public class ProductService {
    private ProductRepository productRepository;
    @Autowired
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
    public void newProduct(Product product){
        productRepository.save(product);
    }
    @Transactional
    public void productEdit(int id, Product product){
        product.setId(id);
        productRepository.save(product);
    }
    @Transactional
    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }
    public List<Product> productProvider(String provider){
        return productRepository.findByProvider(provider);
    }
    public  List<Product> findByNameOrderByName(String name){
        return productRepository.findByNameOrderByName(name);
    }
}
