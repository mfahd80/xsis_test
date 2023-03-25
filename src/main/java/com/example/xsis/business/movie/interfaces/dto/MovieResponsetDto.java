package com.example.xsis.business.movie.interfaces.dto;

import com.example.xsis.business.shared_domain.base.dto.AuditableBaseDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieResponsetDto extends AuditableBaseDto {

    private String title;
    private String description;
    private Float rating;
    private String image;
}
