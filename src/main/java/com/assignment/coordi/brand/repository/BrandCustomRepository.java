package com.assignment.coordi.brand.repository;

import com.assignment.coordi.brand.entity.Brand;

import java.util.Optional;

public interface BrandCustomRepository {
  Optional<Brand> findBrandWithLowestTotalPrice();
}
