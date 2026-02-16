package com.example.platzi_play.persistence.mapper;

import com.example.platzi_play.domain.Genre;
import org.mapstruct.Named;

public class GenreMapper {

    @Named("stringToGenre")
    public static Genre stringToGenre(String genreStr) {
        if (genreStr == null) return null;

        return  switch (genreStr.toUpperCase()) {
            case "ACTION" -> Genre.ACTION;
            case "COMEDY" -> Genre.COMEDY;
            case "DRAMA" -> Genre.DRAMA;
            case "HORROR" -> Genre.HORROR;
            case "SCIENCE_FICTION", "SCIENCE FICTION", "SCI-FI" -> Genre.SCIENCE_FICTION;
            case "ROMANCE" -> Genre.ROMANCE;
            case "THRILLER" -> Genre.THRILLER;
            case "FANTASY" -> Genre.FANTASY;
            case "ANIMATION" -> Genre.ANIMATION;
            case "ADVENTURE" -> Genre.ADVENTURE;
            default -> null; // or throw an exception if you prefer
        };
    }

    @Named("genreToString")
    public static String genreToString(Genre genre) {
        if (genre == null) return null;

        return switch (genre) {
            case ACTION -> "ACTION";
            case COMEDY -> "COMEDY";
            case DRAMA -> "DRAMA";
            case HORROR -> "HORROR";
            case SCIENCE_FICTION -> "SCIENCE_FICTION";
            case ROMANCE -> "ROMANCE";
            case THRILLER -> "THRILLER";
            case FANTASY -> "FANTASY";
            case ANIMATION -> "ANIMATION";
            case ADVENTURE -> "ADVENTURE";
        };
    }
}
