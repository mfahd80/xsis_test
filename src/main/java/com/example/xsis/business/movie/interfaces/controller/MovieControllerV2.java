package com.example.xsis.business.movie.interfaces.controller;

import com.example.xsis.business.movie.application.command.MovieCommandService;
import com.example.xsis.business.movie.application.query.MovieQueryService;
import com.example.xsis.business.movie.domain.entities.MovieEntity;
import com.example.xsis.business.movie.interfaces.dto.MovieRequestDtoV2;
import com.example.xsis.business.movie.interfaces.transform.MovieTransform;
import com.example.xsis.business.shared_domain.base.dto.GlobalException;
import com.example.xsis.business.shared_domain.base.dto.GlobalResponse;
import com.example.xsis.business.shared_domain.base.dto.PagableData;
import com.example.xsis.business.shared_domain.base.enums.StatusCode;
import com.example.xsis.business.shared_domain.constant.GlobalMessage;
import com.example.xsis.business.shared_domain.util.ResponseGenerator;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/movies/v2")
public class MovieControllerV2 {

    private final ResponseGenerator<Object> responseGenerator;
    private final MovieCommandService movieCommandService;
    private final MovieQueryService movieQueryService;
    private final MovieTransform movieTransform;


    @PostMapping("")
    public ResponseEntity<GlobalResponse<Object>> createMovie(@RequestBody @Valid MovieRequestDtoV2 request){
        return ResponseEntity.ok(
                responseGenerator.generateResponse(
                        StatusCode.OK,
                        movieTransform.entityToResp(movieCommandService.createMovieV2(request))
                )
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GlobalResponse<Object>> updateMovie(@RequestBody @Valid MovieRequestDtoV2 request, @PathVariable("id") Integer id){
        return ResponseEntity.ok(
                responseGenerator.generateResponse(
                        StatusCode.OK,
                        movieTransform.entityToResp(movieCommandService.updateMovieV2(id, request))
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalResponse<Object>> deleteMovie(@PathVariable("id") Integer id){
        movieCommandService.deleteMovie(id);
        return ResponseEntity.ok(
                responseGenerator.generateResponse(
                        StatusCode.OK,
                        null
                )
        );
    }

    @GetMapping("")
    public ResponseEntity<GlobalResponse<Object>> listMovie(
            @RequestParam(value = "page", defaultValue = "${spring.data.rest.default-current-page}") int page,
            @RequestParam(value = "size", defaultValue = "${spring.data.rest.default-page-size}") int size,
            @RequestParam(value = "search", required = false) String search
    ){

        Page<MovieEntity> moviePage = movieQueryService.findAllBySearch(page, size, search);

        return ResponseEntity.ok(
                responseGenerator.generatePageResponse(
                        StatusCode.OK,
                        page,
                        new PagableData<>(moviePage, movieTransform.entityToListResp(moviePage.getContent()))
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalResponse<Object>> detailMovie(@PathVariable("id") Integer id){
        Optional<MovieEntity> movie = movieQueryService.findById(id);

        if (movie.isEmpty())
            throw new GlobalException(StatusCode.NOT_FOUND,
                    GlobalMessage.MOVIE_NOT_FOUND.replaceAll(GlobalMessage.paramVariable[0], id.toString()));

        return ResponseEntity.ok(
                responseGenerator.generateResponse(
                        StatusCode.OK,
                        movieTransform.entityToResp(movie.get())
                )
        );
    }

}
