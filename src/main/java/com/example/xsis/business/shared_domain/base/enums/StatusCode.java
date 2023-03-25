package com.example.xsis.business.shared_domain.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum StatusCode {
  OK(HttpStatus.OK, "XSIS-200", "success"),
  NOT_FOUND(HttpStatus.NOT_FOUND, "XSIS-404", "data not found"),
  BAD_REQUEST(HttpStatus.BAD_REQUEST, "XSIS-400", "request is not valid"),
  INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "XSIS-500", "something went wrong, please contact administrator"),
  ;

  private final HttpStatus httpStatus;
  private final String code;
  private final String message;

}
