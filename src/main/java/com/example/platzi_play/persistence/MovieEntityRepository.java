package com.example.platzi_play.persistence;

import com.example.platzi_play.domain.dto.MovieDto;
import com.example.platzi_play.domain.repository.MovieRepository;
import com.example.platzi_play.persistence.crud.CrudMovieEntity;
import com.example.platzi_play.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieEntityRepository implements MovieRepository {
    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
        this.crudMovieEntity = crudMovieEntity;
    }

    @Override
    public List<MovieDto> findAll() {
        return this.movieMapper.toDto(this.crudMovieEntity.findAll());
    }

    @Override
    public MovieDto findById(Long id) {
        return this.movieMapper.toDto(this.crudMovieEntity.findById(id).orElse(null));
    }
}
