package com.assignment.coordi.product.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {
  @JsonProperty("가격")
  private BigDecimal price;

  @JsonProperty("브랜드아이디")
  private Long brandId;

  @JsonProperty("카테고리아이디")
  private Long categoryId;
}