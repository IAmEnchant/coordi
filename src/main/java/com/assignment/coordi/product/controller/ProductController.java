package com.assignment.coordi.product.controller;

import com.assignment.coordi.product.dto.request.ProductRequestDto;
import com.assignment.coordi.product.dto.response.CategoryPriceInfoResponseDto;
import com.assignment.coordi.product.dto.response.LowestPriceByCategoryResponseDto;
import com.assignment.coordi.product.dto.response.ProductResponseDto;
import com.assignment.coordi.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
  private final ProductService productService;

  @GetMapping("/lowest-category")
  public ResponseEntity<LowestPriceByCategoryResponseDto> getLowestCategory() {
    LowestPriceByCategoryResponseDto responseDto =
      productService.getLowestPriceByCategory();
    return ResponseEntity.ok(responseDto);
  }

  @GetMapping("/category-price")
  public ResponseEntity<CategoryPriceInfoResponseDto> getCategoryPrice(
    @RequestParam String category
  ) {
    CategoryPriceInfoResponseDto responseDto =
      productService.getCategoryPriceInfo(category);
    return ResponseEntity.ok(responseDto);
  }

  @GetMapping
  public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
    List<ProductResponseDto> responseDtos = productService.getAllProducts();
    return ResponseEntity.ok(responseDtos);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductResponseDto> getProductById(
    @PathVariable Long id
  ) {
    ProductResponseDto responseDto = productService.getProductById(id);
    return ResponseEntity.ok(responseDto);
  }

  @PostMapping
  public ResponseEntity<ProductResponseDto> createProduct(
    @RequestBody ProductRequestDto requestDto
  ) {
    ProductResponseDto responseDto = productService.createProduct(requestDto);
    return ResponseEntity.ok(responseDto);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProductResponseDto> updateProduct(
    @PathVariable Long id,
    @RequestBody ProductRequestDto requestDto
  ) {
    ProductResponseDto responseDto =
      productService.updateProduct(id, requestDto);
    return ResponseEntity.ok(responseDto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
    productService.deleteProduct(id);
    return ResponseEntity.ok().build();
  }
}
