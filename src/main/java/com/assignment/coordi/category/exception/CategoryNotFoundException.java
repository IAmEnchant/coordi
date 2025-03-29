package com.assignment.coordi.category.exception;

import com.assignment.coordi.global.exception.NotFoundException;

public class CategoryNotFoundException extends NotFoundException {
  public CategoryNotFoundException(String message) {
    super(message);
  }
}