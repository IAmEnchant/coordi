package com.assignment.coordi.category.service;

import com.assignment.coordi.category.dto.request.CategoryRequestDto;
import com.assignment.coordi.category.dto.response.CategoryResponseDto;
import com.assignment.coordi.category.entity.Category;
import com.assignment.coordi.category.exception.CategoryNotFoundException;
import com.assignment.coordi.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
  private final CategoryRepository categoryRepository;

  public List<CategoryResponseDto> getAllCategories() {
    return categoryRepository.findAll().stream()
      .map(category -> CategoryResponseDto.builder()
        .id(category.getId())
        .name(category.getName())
        .build())
      .collect(Collectors.toList());
  }

  public CategoryResponseDto getCategoryById(Long id) {
    Category category = categoryRepository.findById(id)
      .orElseThrow(() -> new CategoryNotFoundException("카테고리를 찾을 수 없습니다."));
    return CategoryResponseDto.builder()
      .id(category.getId())
      .name(category.getName())
      .build();
  }

  public CategoryResponseDto createCategory(CategoryRequestDto requestDto) {
    Category category = Category.builder()
      .name(requestDto.getName())
      .build();
    Category saved = categoryRepository.save(category);
    return CategoryResponseDto.builder()
      .id(saved.getId())
      .name(saved.getName())
      .build();
  }

  public CategoryResponseDto updateCategory(
    Long id, CategoryRequestDto requestDto
  ) {
    Category updated = categoryRepository.findById(id).map(category -> {
      category.setName(requestDto.getName());
      return categoryRepository.save(category);
    }).orElseThrow(() -> new CategoryNotFoundException("카테고리를 찾을 수 없습니다."));
    return CategoryResponseDto.builder()
      .id(updated.getId())
      .name(updated.getName())
      .build();
  }

  public void deleteCategory(Long id) {
    if (!categoryRepository.existsById(id)) {
      throw new CategoryNotFoundException("삭제할 카테고리가 존재하지 않습니다.");
    }
    categoryRepository.deleteById(id);
  }

  // 다른 도메인에서 카테고리 엔티티가 필요할 때 호출하는 전용 메서드
  public Category getCategoryEntity(Long id) {
    return categoryRepository.findById(id)
      .orElseThrow(() -> new CategoryNotFoundException("지정한 카테고리를 찾을 수 없습니다."));
  }
}
