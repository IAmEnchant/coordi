package com.assignment.coordi.product.dto.response;

import com.assignment.coordi.global.dto.CategoryPriceDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LowestPriceByCategoryResponseDto {
  @JsonProperty("카테고리")
  private List<CategoryPriceDto> categoryList;

  @JsonProperty("총액")
  private BigDecimal totalAmount;
}