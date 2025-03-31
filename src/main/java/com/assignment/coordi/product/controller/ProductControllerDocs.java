package com.assignment.coordi.product.controller;

import com.assignment.coordi.product.dto.request.ProductRequestDto;
import com.assignment.coordi.product.dto.response.CategoryPriceInfoResponseDto;
import com.assignment.coordi.product.dto.response.LowestPriceByCategoryResponseDto;
import com.assignment.coordi.product.dto.response.ProductResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name = "상품 API", description = "상품 관련 CRUD 및 카테고리별, 특정 카테고리 가격 조회 API")
public interface ProductControllerDocs {
  @Operation(
    summary = "카테고리별 최저가격 및 총액 조회", description = "각 카테고리의 최저가격과 총액을 조회합니다.")
  @GetMapping("/lowest-category")
  ResponseEntity<LowestPriceByCategoryResponseDto> getLowestCategory();

  @Operation(
    summary = "특정 카테고리 최저/최고 가격 조회",
    description = "지정한 카테고리의 최저 및 최고 가격 정보를 조회합니다.")
  @GetMapping("/category-price")
  ResponseEntity<CategoryPriceInfoResponseDto> getCategoryPrice(
    @RequestParam
    String category
  );

  @Operation(summary = "모든 상품 조회", description = "전체 상품 목록을 조회합니다.")
  @GetMapping
  ResponseEntity<List<ProductResponseDto>> getAllProducts();

  @Operation(summary = "단일 상품 조회", description = "지정한 ID의 상품 정보를 조회합니다.")
  @GetMapping("/{id}")
  ResponseEntity<ProductResponseDto> getProductById(Long id);

  @Operation(
    summary = "상품 생성",
    description = "새로운 상품을 생성합니다. 브랜드 ID와 카테고리 ID를 지정하여 등록합니다.")
  @PostMapping
  ResponseEntity<ProductResponseDto> createProduct(

    ProductRequestDto requestDto
  );

  @Operation(summary = "상품 수정", description = "지정한 ID의 상품 정보를 수정합니다.")
  @PutMapping("/{id}")
  ResponseEntity<ProductResponseDto> updateProduct(
    Long id, ProductRequestDto requestDto
  );

  @Operation(summary = "상품 삭제", description = "지정한 ID의 상품을 삭제합니다.")
  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteProduct(Long id);
}
