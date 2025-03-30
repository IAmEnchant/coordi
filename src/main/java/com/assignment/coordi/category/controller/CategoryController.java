package com.assignment.coordi.category.controller;

import com.assignment.coordi.category.dto.request.CategoryRequestDto;
import com.assignment.coordi.category.dto.response.CategoryResponseDto;
import com.assignment.coordi.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
  private final CategoryService categoryService;

  @GetMapping
  public ResponseEntity<List<CategoryResponseDto>> getAllCategories() {
    List<CategoryResponseDto> responseDtos = categoryService.getAllCategories();
    return ResponseEntity.ok(responseDtos);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CategoryResponseDto> getCategoryById(
    @PathVariable
    Long id
  ) {
    CategoryResponseDto responseDto = categoryService.getCategoryById(id);
    return ResponseEntity.ok(responseDto);
  }

  @PostMapping
  public ResponseEntity<CategoryResponseDto> createCategory(
    @RequestBody CategoryRequestDto requestDto
  ) {
    CategoryResponseDto responseDto =
      categoryService.createCategory(requestDto);
    return ResponseEntity.ok(responseDto);
  }

  @PutMapping("/{id}")
  public ResponseEntity<CategoryResponseDto> updateCategory(
    @PathVariable Long id,
    @RequestBody CategoryRequestDto requestDto
  ) {
    CategoryResponseDto responseDto =
      categoryService.updateCategory(id, requestDto);
    return ResponseEntity.ok(responseDto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
    categoryService.deleteCategory(id);
    return ResponseEntity.ok().build();
  }
}
