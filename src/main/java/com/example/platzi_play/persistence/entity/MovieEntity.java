package com.example.platzi_play.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 155)
    private String title;
    private String description;

    @Column(nullable = false, precision = 3)
    private Integer duration;

    @Column(nullable = false, length = 40)
    private String genre;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(precision = 3, scale = 2)
    private BigDecimal rating;

    @Column(nullable = false, length = 1)
    private String status;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public String getStatus() {
        return status;
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
