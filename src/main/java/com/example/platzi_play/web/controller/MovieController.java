package com.example.platzi_play.web.controller;

import com.example.platzi_play.domain.dto.MovieDto;
import com.example.platzi_play.domain.dto.UpdateMovieDto;
import com.example.platzi_play.domain.repository.MovieRepository;
import com.example.platzi_play.domain.service.MovieService;
import com.example.platzi_play.persistence.crud.CrudMovieEntity;
import com.example.platzi_play.persistence.entity.MovieEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(
            MovieService movieService
    ) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> findAll() {
        List<MovieDto> movieDto = this.movieService.findAll();
        return ResponseEntity.ok(movieDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> findById(@PathVariable Long id) {
        MovieDto movieDto = this.movieService.findById(id);
        return ResponseEntity.ok(movieDto);
    }

    @PostMapping
    public ResponseEntity<MovieDto> save(@RequestBody MovieDto movieDto) {
        MovieDto savedMovie = this.movieService.save(movieDto);
        return ResponseEntity.ok(savedMovie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable Long id, @RequestBody UpdateMovieDto updateMovieDto) {
        MovieDto updateMovie = this.movieService.update(id, updateMovieDto);
        if (updateMovie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateMovie);
    }
}
