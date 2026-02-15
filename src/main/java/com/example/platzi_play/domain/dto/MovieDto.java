package com.example.platzi_play.domain.dto;

public record MovieDto(
        Long movieId,
        String movieTitle,
        String movieDescription,
        Integer duration,
        String genre,
        String releaseDate,
        String rating
) {
}
