package com.ness.movie_release_notifier.service;

import com.ness.movie_release_notifier.model.OmdbWrapper;
import org.springframework.stereotype.Service;

@Service
public class TelegramServiceImpl implements TelegramService {
    @Override
    public void notifyByTelegram(String telegramId, OmdbWrapper omdbWrapper) {

    }
}
