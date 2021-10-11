package com.geekbrains.backend.repository;

import com.geekbrains.backend.persist.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category getById(Integer id);

    void deleteById(Integer id);

}
