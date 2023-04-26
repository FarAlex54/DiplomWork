package com.example.products.repositories;

import com.example.products.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    //select * from product_site where provider = {provider};
    List<Product> findByProvider(String provider);
    //select * from product_site order by name;
    List<Product> findByNameOrderByName(String name);
}
