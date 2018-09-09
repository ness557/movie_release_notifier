package com.ness.movie_release_notifier.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ness.movie_release_notifier.util.OmdbLocalDateDeserializer;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@ToString
public class OmdbWrapper implements Serializable {

    @JsonProperty(value = "Title")
    private String title;

    @JsonProperty(value = "Year")
    private String year;

    @JsonProperty(value = "imdbID")
    private String imdbId;

    @JsonProperty(value = "type")
    private String type;

    @JsonProperty(value = "Poster")
    private String posterUrl;

    @JsonProperty(value = "DVD")
    @JsonDeserialize(using = OmdbLocalDateDeserializer.class)
    private LocalDate dvdDate;

    public static OmdbWrapper wrap(Film film){
        OmdbWrapper wrapper = new OmdbWrapper();
        wrapper.setTitle(film.getTitle());
        wrapper.setYear(String.valueOf(film.getReleaseDate().getYear()));
        wrapper.setImdbId(film.getImdbId());
        wrapper.setPosterUrl(film.getPosterUrl());
        wrapper.setType(film.getType());
        wrapper.setDvdDate(film.getDvdDate());
        return wrapper;
    }
}
