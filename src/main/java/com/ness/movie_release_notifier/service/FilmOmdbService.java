package com.ness.movie_release_notifier.service;

import com.ness.movie_release_notifier.model.OmdbFullWrapper;
import com.ness.movie_release_notifier.model.OmdbSearchResultWrapper;

public interface FilmOmdbService {

    OmdbSearchResultWrapper search(String title);
    OmdbSearchResultWrapper search(String title, int page);
    OmdbSearchResultWrapper search(String title, int year, int page);
    OmdbFullWrapper getInfo(String imdbId);
}
