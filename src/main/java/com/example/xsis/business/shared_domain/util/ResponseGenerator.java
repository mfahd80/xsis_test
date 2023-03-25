package com.example.xsis.business.shared_domain.util;

import com.example.xsis.business.shared_domain.base.dto.GlobalResponse;
import com.example.xsis.business.shared_domain.base.dto.PagableData;
import com.example.xsis.business.shared_domain.base.dto.PageResponse;
import com.example.xsis.business.shared_domain.base.enums.StatusCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ResponseGenerator<T> {

    private final TimeConverter timeConverter;

    public GlobalResponse<Object> generateResponse(StatusCode statusCode, T result){
        return new GlobalResponse<>(timeConverter.localDateTimetoString(LocalDateTime.now()),
                    statusCode.getCode(),
                    statusCode.getMessage(),
                    result
                );
    }

    public GlobalResponse<Object> generatePageResponse(StatusCode statusCode, Integer currentPage, PagableData data){
        PageResponse<Object> response = new PageResponse<>(
                currentPage,
                data.getPage().getTotalPages(),
                longToInteger(data.getPage().getTotalElements()),
                longToInteger(data.getPage().getPageable().getOffset()),
                data.getPage().getPageable().getPageSize(),
                data.getContentList()
        );

        return generateResponse(statusCode, (T) response);
    }

    private Integer longToInteger(Long number){
        return Math.toIntExact(number);
    }
}
