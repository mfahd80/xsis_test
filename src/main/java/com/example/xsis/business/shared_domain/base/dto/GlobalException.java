package com.example.xsis.business.shared_domain.base.dto;

import com.example.xsis.business.shared_domain.base.enums.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Slf4j
@Data
@AllArgsConstructor
public class GlobalException extends RuntimeException implements Serializable {

  final StatusCode statusCode;

  final String message;
}
