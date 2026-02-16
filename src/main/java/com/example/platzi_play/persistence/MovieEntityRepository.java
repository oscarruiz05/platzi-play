package com.example.platzi_play.persistence;

import com.example.platzi_play.domain.dto.MovieDto;
import com.example.platzi_play.domain.dto.UpdateMovieDto;
import com.example.platzi_play.domain.repository.MovieRepository;
import com.example.platzi_play.persistence.crud.CrudMovieEntity;
import com.example.platzi_play.persistence.entity.MovieEntity;
import com.example.platzi_play.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
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

    @Override
    public MovieDto save(MovieDto movieDto) {
        MovieEntity movieEntity = this.movieMapper.toEntity(movieDto);
        movieEntity.setStatus("A");
        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public MovieDto update(Long id, UpdateMovieDto updateMovieDto) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);
        if (movieEntity == null) return null;

        movieEntity.setTitle(updateMovieDto.movieTitle());
        movieEntity.setDescription(updateMovieDto.movieDescription());
        movieEntity.setReleaseDate(LocalDate.parse(updateMovieDto.releaseDate()));
        movieEntity.setRating(BigDecimal.valueOf(updateMovieDto.rating()));

        return  this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }
}
