package com.example.platzi_play.domain.repository;

import com.example.platzi_play.domain.dto.MovieDto;

import java.util.List;

public interface MovieRepository {
    List<MovieDto> findAll();
    MovieDto findById(Long id);
}
