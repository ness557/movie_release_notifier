package com.ness.movie_release_notifier.service;

import com.ness.movie_release_notifier.model.Film;
import com.ness.movie_release_notifier.model.OmdbWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class NotificationServiceImpl implements NotificationService{

    @Autowired
    private FilmService filmService;

    private void notifyByEmail(Map<String, List<OmdbWrapper>> notifies){

    }

    private void notifyByTelegram(Map<String, List<OmdbWrapper>> notifies){

    }

    @Scheduled(cron = "${cron.pattern.notify}")
    @Override
    public void notifyUsers() {

        List<Film> films = filmService.getAll();

        LocalDate endDate = LocalDate.now().minusWeeks(1);
        LocalDate startDate = endDate.minusWeeks(1);

        Map<String, List<OmdbWrapper>> telegramNotifies = new HashMap<>();
        Map<String, List<OmdbWrapper>> emailNotifies = new HashMap<>();
        List<Film> toDelete = new LinkedList<>();

        films.forEach(f -> {
            if (f.getDvdDate().isBefore(endDate) && f.getDvdDate().isAfter(startDate)) {

                toDelete.add(f);
                if (f.getUser().isTelegramNotify()) {
                    addNotify(f, telegramNotifies, f.getUser().getTelegramId());
                } else {
                    addNotify(f, emailNotifies, f.getUser().getEmail());
                }
            }
        });
        notifyByEmail(emailNotifies);
        notifyByTelegram(telegramNotifies);

        filmService.delete(toDelete);
    }

    private void addNotify(Film f, Map<String, List<OmdbWrapper>> notifies, String userAddress){
        notifies.computeIfAbsent(userAddress, k -> new ArrayList<>());
        notifies.get(userAddress).add(OmdbWrapper.wrap(f));
    }
}
