package com.assignment.coordi.product.repository;

import com.assignment.coordi.product.entity.Product;
import com.assignment.coordi.product.entity.QProduct;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductCustomRepositoryImpl implements ProductCustomRepository {
  private final JPAQueryFactory queryFactory;
  private final QProduct product = QProduct.product;

  @Override
  public Optional<Product> findLowestPriceProductByCategory(
    String categoryName
  ) {
    Product result = queryFactory.selectFrom(product)
      .where(product.category.name.eq(categoryName))
      .orderBy(product.price.asc())
      .fetchFirst();
    return Optional.ofNullable(result);
  }

  @Override
  public Optional<Product> findHighestPriceProductByCategory(
    String categoryName
  ) {
    Product result = queryFactory.selectFrom(product)
      .where(product.category.name.eq(categoryName))
      .orderBy(product.price.desc())
      .fetchFirst();
    return Optional.ofNullable(result);
  }
}
