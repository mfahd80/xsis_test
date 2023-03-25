package com.example.xsis.business.movie.interfaces.controller;

import com.example.xsis.business.movie.application.command.MovieCommandService;
import com.example.xsis.business.movie.application.query.MovieQueryService;
import com.example.xsis.business.movie.domain.entities.MovieEntity;
import com.example.xsis.business.movie.interfaces.dto.MovieRequestDto;
import com.example.xsis.business.movie.interfaces.dto.MovieResponsetDto;
import com.example.xsis.business.movie.interfaces.transform.MovieTransform;
import com.example.xsis.business.shared_domain.base.dto.GlobalException;
import com.example.xsis.business.shared_domain.base.enums.StatusCode;
import com.example.xsis.business.shared_domain.constant.GlobalMessage;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/movies")
public class MovieController {

    private final MovieCommandService movieCommandService;
    private final MovieQueryService movieQueryService;
    private final MovieTransform movieTransform;


    @PostMapping("")
    public ResponseEntity<Object> createMovie(@RequestBody @Valid MovieRequestDto request){
        return ResponseEntity.ok(movieCommandService.createMovie(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateMovie(@RequestBody @Valid MovieRequestDto request, @PathVariable("id") Integer id){
        return ResponseEntity.ok(movieCommandService.updateMovie(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMovie(@PathVariable("id") Integer id){
        movieCommandService.deleteMovie(id);
        return ResponseEntity.ok(StatusCode.OK.getMessage());
    }

    @GetMapping("")
    public ResponseEntity<List<MovieResponsetDto>> listMovie(){
        return ResponseEntity.ok(movieTransform.entityToListResp(movieQueryService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponsetDto> detailMovie(@PathVariable("id") Integer id){
        Optional<MovieEntity> movie = movieQueryService.findById(id);

        if (movie.isEmpty())
            throw new GlobalException(StatusCode.NOT_FOUND,
                    GlobalMessage.MOVIE_NOT_FOUND.replaceAll(GlobalMessage.paramVariable[0], id.toString()));

        return ResponseEntity.ok(movieTransform.entityToResp(movie.get()));
    }

}
