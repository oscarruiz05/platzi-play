package com.example.platzi_play.domain.dto;

import com.example.platzi_play.domain.Genre;

public record MovieDto(
        Long movieId,
        String movieTitle,
        String movieDescription,
        Integer duration,
        Genre genre,
        String releaseDate,
        String rating
) {
}
