package com.example.diplomwork.repositories;

import com.example.diplomwork.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    com.example.diplomwork.models.Category findByName(String name);
}
