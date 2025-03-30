package com.assignment.coordi.brand.service;

import com.assignment.coordi.brand.dto.request.BrandRequestDto;
import com.assignment.coordi.brand.dto.response.BrandResponseDto;
import com.assignment.coordi.brand.dto.response.LowestSingleBrandResponseDto;
import com.assignment.coordi.brand.entity.Brand;
import com.assignment.coordi.brand.exception.BrandNotFoundException;
import com.assignment.coordi.brand.repository.BrandRepository;
import com.assignment.coordi.global.dto.CategoryPriceDto;
import com.assignment.coordi.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandService {
  private final BrandRepository brandRepository;

  public LowestSingleBrandResponseDto getLowestTotalForSingleBrand() {
    Optional<Brand> lowestBrandOpt =
      brandRepository.findBrandWithLowestTotalPrice();
    if (lowestBrandOpt.isPresent()) {
      Brand lowestBrand = lowestBrandOpt.get();
      BigDecimal total = lowestBrand.getProducts().stream()
        .map(Product::getPrice)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
      List<CategoryPriceDto> categoryPrices = lowestBrand.getProducts().stream()
        .map(product -> CategoryPriceDto.builder()
          .categoryName(product.getCategory().getName())
          .brandName(lowestBrand.getName())
          .price(product.getPrice())
          .build())
        .collect(Collectors.toList());
      return LowestSingleBrandResponseDto.builder()
        .brandName(lowestBrand.getName())
        .categoryList(categoryPrices)
        .totalAmount(total)
        .build();
    } else {
      throw new BrandNotFoundException("최저 총액을 가진 브랜드를 찾을 수 없습니다.");
    }
  }

  public BrandResponseDto createBrand(BrandRequestDto requestDto) {
    Brand brand = Brand.builder()
      .name(requestDto.getName())
      .build();
    Brand saved = brandRepository.save(brand);
    return BrandResponseDto.builder()
      .id(saved.getId())
      .name(saved.getName())
      .build();
  }

  public BrandResponseDto updateBrand(Long id, BrandRequestDto requestDto) {
    Brand updated = brandRepository.findById(id).map(brand -> {
      brand.setName(requestDto.getName());
      return brandRepository.save(brand);
    }).orElseThrow(() -> new BrandNotFoundException("브랜드를 찾을 수 없습니다."));
    return BrandResponseDto.builder()
      .id(updated.getId())
      .name(updated.getName())
      .build();
  }

  public void deleteBrand(Long id) {
    if (!brandRepository.existsById(id)) {
      throw new BrandNotFoundException("삭제할 브랜드가 존재하지 않습니다.");
    }
    brandRepository.deleteById(id);
  }

  public Brand getBrandEntity(Long id) {
    return brandRepository.findById(id)
      .orElseThrow(() -> new BrandNotFoundException("지정한 브랜드를 찾을 수 없습니다."));
  }
}
