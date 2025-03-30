package com.assignment.coordi.brand.dto.response;

import com.assignment.coordi.product.dto.response.ProductResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrandResponseDto {
  @JsonProperty("아이디")
  private Long id;

  @JsonProperty("브랜드명")
  private String name;

  @JsonProperty("제품")
  private List<ProductResponseDto> products;
}