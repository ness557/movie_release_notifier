package com.ness.movie_release_notifier.service;

import com.ness.movie_release_notifier.model.Film;
import com.ness.movie_release_notifier.model.OmdbWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NotificationServiceImpl implements NotificationService{

    @Autowired
    private FilmService filmService;

    @Autowired
    private UserService userService;

    private void notifyByEmail(Map<String, OmdbWrapper> notifies){

    }

    private void notifyByTelegram(Map<String, OmdbWrapper> notifies){

    }

    @Scheduled(cron = "${cron.pattern.notify}")
    @Override
    public void notifyUsers() {

        List<Film> films = filmService.getAll();

        LocalDate endDate = LocalDate.now().minusWeeks(1);
        LocalDate startDate = endDate.minusWeeks(1);

        Map<String, OmdbWrapper> telegramNotifies = new HashMap<>();
        Map<String, OmdbWrapper> emailNotifies = new HashMap<>();

        films.forEach(f -> {
            if (f.getDvdDate().isBefore(endDate) && f.getDvdDate().isAfter(startDate)) {

                if (f.getUser().isTelegramNotify()) {
                    telegramNotifies.put(f.getUser().getTelegramId(), OmdbWrapper.wrap(f));
                } else {
                    emailNotifies.put(f.getUser().getEmail(), OmdbWrapper.wrap(f));
                }
            }
        });
        notifyByEmail(emailNotifies);
        notifyByTelegram(telegramNotifies);

        //TODO make db clean
    }
}
