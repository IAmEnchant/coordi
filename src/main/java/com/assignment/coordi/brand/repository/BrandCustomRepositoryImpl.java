package com.assignment.coordi.brand.repository;

import com.assignment.coordi.brand.entity.Brand;
import com.assignment.coordi.brand.entity.QBrand;
import com.assignment.coordi.product.entity.QProduct;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BrandCustomRepositoryImpl implements BrandCustomRepository {
  private final JPAQueryFactory queryFactory;

  @Override
  public Optional<Brand> findBrandWithLowestTotalPrice() {
    QBrand brand = QBrand.brand;
    QProduct product = QProduct.product;

    Tuple result = queryFactory.select(brand, product.price.sumBigDecimal())
      .from(brand)
      .join(brand.products, product)
      .groupBy(brand.id)
      .orderBy(product.price.sumBigDecimal().asc())
      .fetchFirst();

    if (result == null) {
      return Optional.empty();
    }

    return Optional.of(result.get(brand));
  }
}
