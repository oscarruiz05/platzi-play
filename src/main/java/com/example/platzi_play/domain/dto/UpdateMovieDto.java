package com.example.platzi_play.domain.dto;

import com.example.platzi_play.domain.Genre;

public record UpdateMovieDto(
        String movieTitle,
        String movieDescription,
        String releaseDate,
        Double rating
) {
}
