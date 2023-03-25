package com.example.xsis.business.movie.interfaces.transform;

import com.example.xsis.business.movie.domain.entities.MovieEntity;
import com.example.xsis.business.movie.interfaces.dto.MovieRequestDto;
import com.example.xsis.business.movie.interfaces.dto.MovieRequestDtoV2;
import com.example.xsis.business.movie.interfaces.dto.MovieResponsetDto;
import com.example.xsis.business.shared_domain.util.TimeConverter;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring",
uses = {
        TimeConverter.class
})
public interface MovieTransform {


    @Mapping(target = "createdAt", qualifiedByName = "stringToLocalDateTime")
    @Mapping(target = "updatedAt", qualifiedByName = "stringToLocalDateTime")
    MovieEntity createFromReq(MovieRequestDto request);

    MovieEntity createFromReqV2(MovieRequestDtoV2 request);

    @Mapping(target = "title", source = "request.title")
    @Mapping(target = "description", source = "request.description")
    @Mapping(target = "rating", source = "request.rating")
    @Mapping(target = "image", source = "request.image")
    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "createdAt", source = "request.createdAt", qualifiedByName = "stringToLocalDateTime")
    @Mapping(target = "updatedAt", source = "request.updatedAt", qualifiedByName = "stringToLocalDateTime")
    MovieEntity updateFromReq(MovieEntity entity, MovieRequestDto request);

    @Mapping(target = "title", source = "request.title")
    @Mapping(target = "description", source = "request.description")
    @Mapping(target = "rating", source = "request.rating")
    @Mapping(target = "image", source = "request.image")
    @Mapping(target = "id", source = "entity.id")
    MovieEntity updateFromReqV2(MovieEntity entity, MovieRequestDtoV2 request);

    @Named("entityToResp")
    @Mapping(target = "createdAt", source = "entity.createdAt", qualifiedByName = "localDateTimetoString")
    @Mapping(target = "updatedAt", source = "entity.updatedAt", qualifiedByName = "localDateTimetoString")
    MovieResponsetDto entityToResp(MovieEntity entity);

    @IterableMapping(qualifiedByName = "entityToResp")
    List<MovieResponsetDto> entityToListResp(List<MovieEntity> entity);

}
