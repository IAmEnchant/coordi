package com.assignment.coordi.category.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponseDto {
  @JsonProperty("아이디")
  private Long id;

  @JsonProperty("카테고리")
  private String name;
}