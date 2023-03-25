package com.example.xsis.business.shared_domain.base.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageResponse<T>{
  @JsonProperty("current_page")
  private Integer currentPage;

  @JsonProperty("total_pages")
  private Integer totalPages;

  @JsonProperty("total_elements")
  private Integer totalElements;

  @JsonProperty("offset_elements")
  private Integer offsetElements;

  @JsonProperty("total_elements_per_page")
  private Integer totalElementsPerPage;

  @JsonProperty("content")
  private List<T> content;

}
