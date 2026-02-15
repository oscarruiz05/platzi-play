package com.example.platzi_play.persistence.crud;

import com.example.platzi_play.persistence.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudMovieEntity  extends JpaRepository<MovieEntity, Long> {
}
