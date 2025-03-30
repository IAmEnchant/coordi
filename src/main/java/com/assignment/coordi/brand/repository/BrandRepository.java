package com.assignment.coordi.brand.repository;

import com.assignment.coordi.brand.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository
  extends JpaRepository<Brand, Long>, BrandCustomRepository {
  Optional<Brand> findByName(String name);
}
