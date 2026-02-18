package com.example.platzi_play.web.controller;

import com.example.platzi_play.domain.dto.MovieDto;
import com.example.platzi_play.domain.dto.RecomendationRequestDto;
import com.example.platzi_play.domain.dto.UpdateMovieDto;
import com.example.platzi_play.domain.service.MovieService;
import com.example.platzi_play.domain.service.PlatziPlayAiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@Tag(name = "Movies", description = "Endpoints for managing movies")
public class MovieController {

    private final MovieService movieService;
    private final PlatziPlayAiService platziPlayAiService;

    public MovieController(
            MovieService movieService,
            PlatziPlayAiService platziPlayAiService
    ) {
        this.movieService = movieService;
        this.platziPlayAiService = platziPlayAiService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> findAll() {
        List<MovieDto> movieDto = this.movieService.findAll();
        return ResponseEntity.ok(movieDto);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get a movie by its ID",
            description = "Returns a single movie based on the provided ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Movie found and returned successfully"),
                    @ApiResponse(responseCode = "404", description = "Movie not found with the provided ID", content = @Content)
            }
    )
    public ResponseEntity<MovieDto> findById(@Parameter(description = "Id movie") @PathVariable Long id) {
        MovieDto movieDto = this.movieService.findById(id);
        return ResponseEntity.ok(movieDto);
    }

    @PostMapping
    public ResponseEntity<MovieDto> save(@RequestBody MovieDto movieDto) {
        MovieDto savedMovie = this.movieService.save(movieDto);
        return ResponseEntity.ok(savedMovie);
    }

    @PostMapping("/recommendation")
    public ResponseEntity<String> generateMovieRecommendation(@RequestBody RecomendationRequestDto recomendationRequestDto) {
        return ResponseEntity.ok(this.platziPlayAiService.generateMovieRecommendation(recomendationRequestDto.userPreference()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable Long id, @RequestBody @Valid UpdateMovieDto updateMovieDto) {
        MovieDto updateMovie = this.movieService.update(id, updateMovieDto);
        if (updateMovie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateMovie);
    }
}
