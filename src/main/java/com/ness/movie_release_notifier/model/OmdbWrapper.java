package com.ness.movie_release_notifier.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
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

    @JsonProperty(value = "Type")
    private String type;

    @JsonProperty(value = "Poster")
    private String posterUrl;

    @JsonProperty(value = "DVD")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy", locale = "en_US")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dvdDate;
}
