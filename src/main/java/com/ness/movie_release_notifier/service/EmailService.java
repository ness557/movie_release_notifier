package com.ness.movie_release_notifier.service;

import com.ness.movie_release_notifier.model.OmdbWrapper;

public interface EmailService {
    void sendNotifyEmail(String emailAddress, OmdbWrapper omdbWrapper);
}
