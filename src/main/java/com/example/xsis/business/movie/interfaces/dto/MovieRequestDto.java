package com.example.xsis.business.movie.interfaces.dto;

import com.example.xsis.business.shared_domain.base.dto.AuditableBaseDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieRequestDto extends AuditableBaseDto {

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private Float rating;

    @NotNull
    private String image;
}
