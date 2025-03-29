package com.assignment.coordi.global.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends BaseException {

  public NotFoundException(String message) {
    super(404, message);
  }
}