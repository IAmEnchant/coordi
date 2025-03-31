package com.assignment.coordi.category.controller;

import com.assignment.coordi.category.dto.request.CategoryRequestDto;
import com.assignment.coordi.category.dto.response.CategoryResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Tag(name = "카테고리 API", description = "카테고리 관련 CRUD API")
public interface CategoryControllerDocs {
  @Operation(summary = "모든 카테고리 조회", description = "전체 카테고리 목록을 조회합니다.")
  @GetMapping
  ResponseEntity<List<CategoryResponseDto>> getAllCategories();

  @Operation(summary = "단일 카테고리 조회", description = "지정한 ID의 카테고리 정보를 조회합니다.")
  @GetMapping("/{id}")
  ResponseEntity<CategoryResponseDto> getCategoryById(Long id);

  @Operation(summary = "카테고리 생성", description = "새로운 카테고리를 생성합니다.")
  @PostMapping
  ResponseEntity<CategoryResponseDto> createCategory(
    CategoryRequestDto requestDto
  );

  @Operation(summary = "카테고리 수정", description = "지정한 ID의 카테고리 정보를 수정합니다.")
  @PutMapping("/{id}")
  ResponseEntity<CategoryResponseDto> updateCategory(
    Long id,
    CategoryRequestDto requestDto
  );

  @Operation(summary = "카테고리 삭제", description = "지정한 ID의 카테고리를 삭제합니다.")
  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteCategory(Long id);
}
