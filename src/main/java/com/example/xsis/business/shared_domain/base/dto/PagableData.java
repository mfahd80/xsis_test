package com.example.xsis.business.shared_domain.base.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@AllArgsConstructor
public class PagableData<T,D> {

  private Page<T> page;

  private List<D> contentList;

}
