package com.example.xsis.business.movie.application.command;

import com.example.xsis.business.movie.domain.entities.MovieEntity;
import com.example.xsis.business.movie.infrastructure.MovieRepository;
import com.example.xsis.business.movie.interfaces.dto.MovieRequestDto;
import com.example.xsis.business.movie.interfaces.dto.MovieRequestDtoV2;
import com.example.xsis.business.movie.interfaces.transform.MovieTransform;
import com.example.xsis.business.shared_domain.base.dto.GlobalException;
import com.example.xsis.business.shared_domain.base.enums.StatusCode;
import com.example.xsis.business.shared_domain.constant.GlobalMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class MovieCommandService {

    private final MovieTransform movieTransform;
    private final MovieRepository movieRepository;
    

    public MovieEntity createMovie(MovieRequestDto requestDto){
        return movieRepository.save(movieTransform.createFromReq(requestDto));
    }

    public MovieEntity updateMovie(Integer id, MovieRequestDto requestDto){
        Optional<MovieEntity> movie = movieRepository.findById(id);

        if (movie.isEmpty())
            throw new GlobalException(StatusCode.NOT_FOUND,
                    GlobalMessage.MOVIE_NOT_FOUND.replaceAll(GlobalMessage.paramVariable[0], id.toString()));

        return movieRepository.save(movieTransform.updateFromReq(movie.get(), requestDto));
    }

    public void deleteMovie(Integer id){
        Optional<MovieEntity> movie = movieRepository.findById(id);
        if (movie.isEmpty())
            throw new GlobalException(StatusCode.NOT_FOUND,
                    GlobalMessage.MOVIE_NOT_FOUND.replaceAll(GlobalMessage.paramVariable[0], id.toString()));

        movieRepository.delete(movie.get());
    }


    public MovieEntity createMovieV2(MovieRequestDtoV2 requestDto){
        return movieRepository.save(movieTransform.createFromReqV2(requestDto));
    }

    public MovieEntity updateMovieV2(Integer id, MovieRequestDtoV2 requestDto){
        Optional<MovieEntity> movie = movieRepository.findById(id);

        if (movie.isEmpty())
            throw new GlobalException(StatusCode.NOT_FOUND,
                    GlobalMessage.MOVIE_NOT_FOUND.replaceAll(GlobalMessage.paramVariable[0], id.toString())
            );

        return movieRepository.save(movieTransform.updateFromReqV2(movie.get(), requestDto));
    }
}
