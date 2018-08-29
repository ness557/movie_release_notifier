package com.ness.movie_release_notifier.service;

import com.ness.movie_release_notifier.model.OmdbSearchResultWrapper;
import com.ness.movie_release_notifier.model.OmdbWrapper;

public interface FilmOmdbService {

    OmdbSearchResultWrapper search(String title);
    OmdbSearchResultWrapper search(String title, int page);
    OmdbSearchResultWrapper search(String title, int year, int page);
    OmdbWrapper getInfo(String imdbId);
}
