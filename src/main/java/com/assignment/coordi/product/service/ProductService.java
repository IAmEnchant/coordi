package com.assignment.coordi.product.service;

import com.assignment.coordi.brand.service.BrandService;
import com.assignment.coordi.category.dto.response.CategoryResponseDto;
import com.assignment.coordi.category.service.CategoryService;
import com.assignment.coordi.global.dto.CategoryPriceDto;
import com.assignment.coordi.global.dto.PriceInfoDto;
import com.assignment.coordi.product.dto.request.ProductRequestDto;
import com.assignment.coordi.product.dto.response.CategoryPriceInfoResponseDto;
import com.assignment.coordi.product.dto.response.LowestPriceByCategoryResponseDto;
import com.assignment.coordi.product.dto.response.ProductResponseDto;
import com.assignment.coordi.product.entity.Product;
import com.assignment.coordi.product.exception.ProductNotFoundException;
import com.assignment.coordi.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;

  private final BrandService brandService;
  private final CategoryService categoryService;

  /**
   * 카테고리 별 최저가 브랜드와 상품 가격, 총액 조회
   *
   * @return LowestPriceByCategoryResponseDto
   */
  public LowestPriceByCategoryResponseDto getLowestPriceByCategory() {
    List<String> categories = categoryService.getAllCategories()
      .stream().map(CategoryResponseDto::getName).toList();

    List<CategoryPriceDto> categoryList =
      categories.stream().map(categoryName -> {
        Optional<Product> optProduct =
          productRepository.findLowestPriceProductByCategory(categoryName);
        if (optProduct.isPresent()) {
          Product product = optProduct.get();
          return CategoryPriceDto.builder()
            .categoryName(categoryName)
            .brandName(product.getBrand().getName())
            .price(product.getPrice())
            .build();
        } else {
          return null;
        }
      }).filter(Objects::nonNull).collect(Collectors.toList());

    BigDecimal totalAmount = categoryList.stream()
      .map(CategoryPriceDto::getPrice)
      .reduce(BigDecimal.ZERO, BigDecimal::add);

    return LowestPriceByCategoryResponseDto.builder()
      .categoryList(categoryList)
      .totalAmount(totalAmount)
      .build();
  }

  /**
   * 카테고리 이름으로 최저/최고 가격 브랜드와 상품 조회
   *
   * @param categoryName
   * @return
   */
  public CategoryPriceInfoResponseDto getCategoryPriceInfo(
    String categoryName
  ) {
    categoryService.findCategoryByName(categoryName);

    Optional<Product> lowestOpt =
      productRepository.findLowestPriceProductByCategory(categoryName);
    Optional<Product> highestOpt =
      productRepository.findHighestPriceProductByCategory(categoryName);

    PriceInfoDto lowest = lowestOpt.map(product ->
      PriceInfoDto.builder()
        .brandName(product.getBrand().getName())
        .price(product.getPrice())
        .build()).orElse(null);

    PriceInfoDto highest = highestOpt.map(product ->
      PriceInfoDto.builder()
        .brandName(product.getBrand().getName())
        .price(product.getPrice())
        .build()).orElse(null);

    return CategoryPriceInfoResponseDto.builder()
      .categoryName(categoryName)
      .lowestPrices(lowest != null ? List.of(lowest) : List.of())
      .highestPrices(highest != null ? List.of(highest) : List.of())
      .build();
  }

  /**
   * 전체 상품 조회
   *
   * @return List<ProductResponseDto>
   */
  public List<ProductResponseDto> getAllProducts() {
    return productRepository.findAll().stream()
      .map(product -> ProductResponseDto.builder()
        .id(product.getId())
        .price(product.getPrice())
        .brandName(product.getBrand().getName())
        .categoryName(product.getCategory().getName())
        .build())
      .collect(Collectors.toList());
  }

  /**
   * 상품 조회
   *
   * @param id
   * @return
   */
  public ProductResponseDto getProductById(Long id) {
    Product product = productRepository.findById(id)
      .orElseThrow(() -> new ProductNotFoundException("제품을 찾을 수 없습니다."));
    return ProductResponseDto.builder()
      .id(product.getId())
      .price(product.getPrice())
      .brandName(product.getBrand().getName())
      .categoryName(product.getCategory().getName())
      .build();
  }

  /**
   * 상품 생성
   *
   * @param requestDto
   * @return ProductResponseDto
   */
  public ProductResponseDto createProduct(ProductRequestDto requestDto) {
    var brand = brandService.getBrandEntity(requestDto.getBrandId());
    var category =
      categoryService.getCategoryEntity(requestDto.getCategoryId());
    Product product = Product.builder()
      .price(requestDto.getPrice())
      .brand(brand)
      .category(category)
      .build();
    Product saved = productRepository.save(product);
    return ProductResponseDto.builder()
      .id(saved.getId())
      .price(saved.getPrice())
      .brandName(saved.getBrand().getName())
      .categoryName(saved.getCategory().getName())
      .build();
  }

  /**
   * 상품 수정
   *
   * @param id
   * @param requestDto
   * @return ProductResponseDto
   */
  public ProductResponseDto updateProduct(
    Long id, ProductRequestDto requestDto
  ) {
    Product updated = productRepository.findById(id).map(product -> {
      product.setPrice(requestDto.getPrice());
      product.setCategory(
        categoryService.getCategoryEntity(requestDto.getCategoryId()));
      return productRepository.save(product);
    }).orElseThrow(() -> new ProductNotFoundException("업데이트할 제품을 찾을 수 없습니다."));
    return ProductResponseDto.builder()
      .id(updated.getId())
      .price(updated.getPrice())
      .brandName(updated.getBrand().getName())
      .categoryName(updated.getCategory().getName())
      .build();
  }

  /**
   * 상품 삭제
   *
   * @param id
   */
  public void deleteProduct(Long id) {
    if (!productRepository.existsById(id)) {
      throw new ProductNotFoundException("삭제할 제품이 존재하지 않습니다.");
    }
    productRepository.deleteById(id);
  }
}