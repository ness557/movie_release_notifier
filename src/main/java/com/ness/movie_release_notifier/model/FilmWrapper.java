package com.ness.movie_release_notifier.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmWrapper {

    private String imdbId;

    private String title;

    private LocalDate releaseDate;

    private LocalDate dvdDate;

    private UserWrapper user;

    public static FilmWrapper wrap(Film film){
        return new FilmWrapper(
                film.getImdbId(),
                film.getTitle(),
                film.getReleaseDate(),
                film.getDvdDate(),
                UserWrapper.wrap(film.getUser()));
    }
}
