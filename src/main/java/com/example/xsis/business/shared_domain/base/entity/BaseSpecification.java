package com.example.xsis.business.shared_domain.base.entity;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class BaseSpecification {

    public Pageable pageGenerator(int page, int size) {
        return PageRequest.of(page, size);
    }

}
