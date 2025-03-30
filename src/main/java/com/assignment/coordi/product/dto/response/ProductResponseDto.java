package com.assignment.coordi.product.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {
  @JsonProperty("아이디")
  private Long id;

  @JsonProperty("가격")
  private BigDecimal price;

  @JsonProperty("카테고리")
  private String categoryName;

  @JsonProperty("브랜드")
  private String brandName;
}