package com.assignment.coordi.brand.dto.response;

import com.assignment.coordi.global.dto.CategoryPriceDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LowestSingleBrandResponseDto {
  @JsonProperty("브랜드")
  private String brandName;

  @JsonProperty("카테고리")
  private List<CategoryPriceDto> categoryList;

  @JsonProperty("총액")
  private BigDecimal totalAmount;
}