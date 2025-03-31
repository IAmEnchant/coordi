package com.assignment.coordi.brand.controller;

import com.assignment.coordi.brand.dto.request.BrandRequestDto;
import com.assignment.coordi.brand.dto.response.BrandResponseDto;
import com.assignment.coordi.brand.dto.response.LowestSingleBrandResponseDto;
import com.assignment.coordi.brand.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/brand")
public class BrandController implements BrandControllerDocs {
  private final BrandService brandService;

  @GetMapping("/lowest-single-brand")
  public ResponseEntity<LowestSingleBrandResponseDto> getLowestSingleBrand() {
    LowestSingleBrandResponseDto responseDto =
      brandService.getLowestTotalForSingleBrand();
    return ResponseEntity.ok(responseDto);
  }

  @PostMapping
  public ResponseEntity<BrandResponseDto> createBrand(
    @RequestBody BrandRequestDto requestDto
  ) {
    BrandResponseDto responseDto = brandService.createBrand(requestDto);
    return ResponseEntity.ok(responseDto);
  }

  @PutMapping("/{id}")
  public ResponseEntity<BrandResponseDto> updateBrand(
    @PathVariable Long id,
    @RequestBody BrandRequestDto requestDto
  ) {
    BrandResponseDto responseDto = brandService.updateBrand(id, requestDto);
    return ResponseEntity.ok(responseDto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBrand(@PathVariable Long id) {
    brandService.deleteBrand(id);
    return ResponseEntity.ok().build();
  }
}
