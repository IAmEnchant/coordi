package com.assignment.coordi.global.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {
  private int status;
  private String message;
  private T data;

  public static <T> CommonResponse<T> success(T data) {
    CommonResponse<T> response = new CommonResponse<>();
    response.data = data;
    response.message = "OK";
    return response;
  }

  public static CommonResponse<Void> success() {
    CommonResponse<Void> response = new CommonResponse<>();
    response.message = "OK";
    return response;
  }

  public static <T> CommonResponse<T> fail(
    Integer code, String message
  ) {
    CommonResponse<T> response = new CommonResponse<>();
    response.status = code;
    response.message = message;
    return response;
  }
}
