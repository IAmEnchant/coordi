package com.assignment.coordi.brand.controller;

import com.assignment.coordi.brand.dto.request.BrandRequestDto;
import com.assignment.coordi.brand.dto.response.BrandResponseDto;
import com.assignment.coordi.brand.dto.response.LowestSingleBrandResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "브랜드 API", description = "브랜드 관련 CRUD 및 단일 브랜드 최저 총액 조회 API")
public interface BrandControllerDocs {
  @Operation(
    summary = "단일 브랜드 최저 총액 조회",
    description = "단일 브랜드로 모든 카테고리 제품 구매 시 최저 총액 및 제품 정보를 조회합니다.")
  ResponseEntity<LowestSingleBrandResponseDto> getLowestSingleBrand();

  @Operation(
    summary = "브랜드 생성", description = "새로운 브랜드를 생성합니다.")
  ResponseEntity<BrandResponseDto> createBrand(BrandRequestDto requestDto);

  @Operation(summary = "브랜드 수정", description = "지정한 ID의 브랜드 정보를 수정합니다.")
  ResponseEntity<BrandResponseDto> updateBrand(
    Long id, BrandRequestDto requestDto
  );

  @Operation(summary = "브랜드 삭제", description = "지정한 ID의 브랜드를 삭제합니다.")
  ResponseEntity<Void> deleteBrand(Long id);
}
