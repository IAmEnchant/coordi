package com.assignment.coordi.category.repository;

import com.assignment.coordi.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
  Optional<Category> findByName(String name);
}
