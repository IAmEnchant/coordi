package com.assignment.coordi.product.repository;

import com.assignment.coordi.product.entity.Product;

import java.util.Optional;

public interface ProductCustomRepository {
  Optional<Product> findLowestPriceProductByCategory(String categoryName);

  Optional<Product> findHighestPriceProductByCategory(String categoryName);
}
