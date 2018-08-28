package com.ness.movie_release_notifier.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "film")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Film {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "imdb_id")
    private String imdbId;

    @Column(name = "title")
    private String title;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "dvd_date")
    private LocalDate dvdDate;

    @ManyToOne
    @JoinColumn(name = "uzer_id")
    private User user;
}