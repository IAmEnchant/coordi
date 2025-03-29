package com.assignment.coordi.global.handler;

import com.assignment.coordi.global.exception.NotFoundException;
import com.assignment.coordi.global.response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<CommonResponse<Void>> handleNotFoundException(
    NotFoundException ex
  ) {
    return new ResponseEntity<>(
      CommonResponse.fail(ex.getErrorCode(), ex.getMessage()),
      HttpStatus.NOT_FOUND
    );
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<CommonResponse<Void>> handleGenericException(
    Exception ex
  ) {
    return new ResponseEntity<>(
      CommonResponse.fail(500, ex.getMessage()),
      HttpStatus.INTERNAL_SERVER_ERROR
    );
  }
}
