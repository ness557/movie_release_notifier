package com.ness.movie_release_notifier.service;

import com.ness.movie_release_notifier.model.Film;

public interface FilmService {
    
    void save(Film film);
    Film get(String title);
    Film get(Long id);
    void delete(Film film);
    void delete(Long id);
    Iterable<Film> getAll();
}
