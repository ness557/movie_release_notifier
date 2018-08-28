package com.ness.movie_release_notifier.service;

import com.ness.movie_release_notifier.model.User;
import org.springframework.stereotype.Service;

public interface UserService {

    void save(User user);
    User get(Long id);
    void delete(User user);
    void delete(Long id);
    Iterable<User> getAll();
    User findByLogin(String login);
}
