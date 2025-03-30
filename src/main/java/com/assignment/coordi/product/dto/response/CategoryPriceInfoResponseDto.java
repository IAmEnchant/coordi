package com.assignment.coordi.product.dto.response;

import com.assignment.coordi.global.dto.PriceInfoDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryPriceInfoResponseDto {
  @JsonProperty("카테고리")
  private String categoryName;

  @JsonProperty("최저가")
  private List<PriceInfoDto> lowestPrices;

  @JsonProperty("최고가")
  private List<PriceInfoDto> highestPrices;
}