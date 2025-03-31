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

  /**
   * 카테고리 목록 가져오기
   *
   * @return
   */
  public List<CategoryResponseDto> getAllCategories() {
    return categoryRepository.findAll().stream()
      .map(category -> CategoryResponseDto.builder()
        .id(category.getId())
        .name(category.getName())
        .build())
      .collect(Collectors.toList());
  }

  /**
   * 카테고리 아이디로 카테고리 정보 가져오기
   *
   * @param id
   * @return CategoryResponseDto
   */
  public CategoryResponseDto getCategoryById(Long id) {
    Category category = categoryRepository.findById(id)
      .orElseThrow(() -> new CategoryNotFoundException("카테고리를 찾을 수 없습니다."));
    return CategoryResponseDto.builder()
      .id(category.getId())
      .name(category.getName())
      .build();
  }

  /**
   * 카테고리 생성
   *
   * @param requestDto
   * @return CategoryResponseDto
   */
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

  /**
   * 카테고리 수정
   *
   * @param id
   * @param requestDto
   * @return CategoryResponseDto
   */
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

  /**
   * 카테고리 삭제
   *
   * @param id
   */
  public void deleteCategory(Long id) {
    if (!categoryRepository.existsById(id)) {
      throw new CategoryNotFoundException("삭제할 카테고리가 존재하지 않습니다.");
    }
    categoryRepository.deleteById(id);
  }

  /**
   * 카테고리 가져오기
   *
   * @param id
   * @return Category
   */
  public Category getCategoryEntity(Long id) {
    return categoryRepository.findById(id)
      .orElseThrow(() -> new CategoryNotFoundException("지정한 카테고리를 찾을 수 없습니다."));
  }

  /**
   * 카테고리 이름으로 가져오기
   *
   * @param name
   * @return Category
   */
  public Category findCategoryByName(String name) {
    return categoryRepository.findByName(name)
      .orElseThrow(() -> new CategoryNotFoundException("지정한 카테고리를 찾을 수 없습니다."));
  }
}
