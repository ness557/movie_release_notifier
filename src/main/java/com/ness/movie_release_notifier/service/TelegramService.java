package com.ness.movie_release_notifier.service;

import com.ness.movie_release_notifier.model.OmdbWrapper;

public interface TelegramService {
    void notifyByTelegram(String telegramId, OmdbWrapper omdbWrapper);
}
