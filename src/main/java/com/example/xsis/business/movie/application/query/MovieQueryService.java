package com.example.xsis.business.movie.application.query;

import com.example.xsis.business.movie.domain.entities.MovieEntity;
import com.example.xsis.business.movie.domain.service.MovieSpecification;
import com.example.xsis.business.movie.infrastructure.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieQueryService {

    private final MovieRepository movieRepository;
    private final MovieSpecification movieSpecification;

    public List<MovieEntity> findAll(){
        return movieRepository.findAll();
    }

    public Optional<MovieEntity> findById(Integer id){
        return movieRepository.findById(id);
    }

    public Page<MovieEntity> findAllBySearch(int page, int size, String search){
        Pageable pageable = movieSpecification.pageGenerator(page, size);
        return movieRepository.findAll(movieSpecification.restrictBy(search), pageable);
    }
}
