package com.example.platzi_play.domain.dto;


import jakarta.validation.constraints.*;

public record UpdateMovieDto(
        @NotBlank(message = "Movie title is required")
        String movieTitle,
        String movieDescription,
        String releaseDate,

        @Min(value = 0, message = "Duration must be a positive number")
        @Max(value = 5, message = "Rating must be less than or equal to 5")
        Double rating
) {
}
