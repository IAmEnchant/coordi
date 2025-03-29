package com.assignment.coordi.global.exception;

import lombok.Getter;

@Getter
public abstract class BaseException extends RuntimeException {
  private final Integer errorCode;

  protected BaseException(Integer errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }
}