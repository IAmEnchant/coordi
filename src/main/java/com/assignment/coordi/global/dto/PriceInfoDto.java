package com.assignment.coordi.global.dto;

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
public class PriceInfoDto {
  @JsonProperty("브랜드")
  private String brandName;

  @JsonProperty("가격")
  private BigDecimal price;
}