package com.ness.movie_release_notifier.service;

import com.ness.movie_release_notifier.model.Film;
import com.ness.movie_release_notifier.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements FilmService{

    @Autowired
    private FilmRepository repository;

    @Override
    public void save(Film film) {
        repository.save(film);
    }

    @Override
    public Film get(String title) {
        return repository.findByTitle(title);
    }

    @Override
    public Film get(Long id) {
        return repository.getOne(id);
    }

    @Override
    public void delete(Film film) {
        repository.delete(film);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<Film> getAll() {
        return repository.findAll();
    }
}
