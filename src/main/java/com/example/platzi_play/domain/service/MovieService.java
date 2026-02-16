package com.example.platzi_play.domain.service;

import com.example.platzi_play.domain.dto.MovieDto;
import com.example.platzi_play.domain.dto.UpdateMovieDto;
import com.example.platzi_play.domain.repository.MovieRepository;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Tool("Busca películas en la base de datos")
    public List<MovieDto> findAll() {
        return this.movieRepository.findAll();
    }

    public MovieDto findById(Long id) {
        return this.movieRepository.findById(id);
    }

    public  MovieDto save(MovieDto movieDto) {
        return this.movieRepository.save(movieDto);
    }

    public  MovieDto update(Long id, UpdateMovieDto updateMovieDto) {
        return this.movieRepository.update(id, updateMovieDto);
    }
}
