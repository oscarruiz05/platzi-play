package com.example.platzi_play.persistence.mapper;

import com.example.platzi_play.domain.dto.MovieDto;
import com.example.platzi_play.persistence.entity.MovieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    @Mapping(source = "id",  target = "movieId")
    @Mapping(source = "title",  target = "movieTitle")
    @Mapping(source = "description",  target = "movieDescription")
    @Mapping(source = "duration",  target = "duration")
    @Mapping(source = "genre",  target = "genre")
    @Mapping(source = "releaseDate",  target = "releaseDate")
    @Mapping(source = "rating",  target = "rating")
    MovieDto toDto(MovieEntity movieEntity);
    List<MovieDto> toDto(List<MovieEntity> movieEntities);
}
