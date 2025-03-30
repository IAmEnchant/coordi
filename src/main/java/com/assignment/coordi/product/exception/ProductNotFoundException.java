package com.assignment.coordi.product.exception;

import com.assignment.coordi.global.exception.NotFoundException;

public class ProductNotFoundException extends NotFoundException {
  public ProductNotFoundException(String message) {
    super(message);
  }
}