package com.assignment.coordi.product.repository;

import com.assignment.coordi.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository
  extends JpaRepository<Product, Long>, ProductCustomRepository {
  List<Product> findByCategory_Name(String categoryName);

  List<Product> findByBrand_Name(String brandName);
}
