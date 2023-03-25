package com.example.xsis.business.shared_domain.config;

import com.example.xsis.business.shared_domain.base.dto.GlobalException;
import com.example.xsis.business.shared_domain.base.dto.GlobalResponse;
import com.example.xsis.business.shared_domain.util.ResponseGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
@AllArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  private final ResponseGenerator<Object> responseGenerator;

  @ExceptionHandler(GlobalException.class)
  protected ResponseEntity<Object> GlobalCustomExceptionHandler(
          GlobalException ex) {

    GlobalResponse<Object> response = responseGenerator.generateResponse(ex.getStatusCode(), ex.getMessage());
    return new ResponseEntity<>(response, new HttpHeaders(), ex.getStatusCode().getHttpStatus());
  }

}