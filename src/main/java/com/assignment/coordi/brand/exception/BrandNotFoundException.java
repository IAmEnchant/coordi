package com.assignment.coordi.brand.exception;

import com.assignment.coordi.global.exception.NotFoundException;

public class BrandNotFoundException extends NotFoundException {
  public BrandNotFoundException(String message) {
    super(message);
  }
}