package com.ness.movie_release_notifier.repository;

import com.ness.movie_release_notifier.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface FilmRepository extends JpaRepository<Film, Long> {
    Film findByTitle(String title);
}
