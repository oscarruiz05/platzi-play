package com.example.platzi_play.domain.service;

import com.example.platzi_play.domain.dto.MovieDto;
import com.example.platzi_play.domain.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> findAll() {
        return this.movieRepository.findAll();
    }
}
