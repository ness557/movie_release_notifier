package com.ness.movie_release_notifier.controller;

import com.ness.movie_release_notifier.model.Film;
import com.ness.movie_release_notifier.model.OmdbFullWrapper;
import com.ness.movie_release_notifier.model.User;
import com.ness.movie_release_notifier.service.FilmOmdbService;
import com.ness.movie_release_notifier.service.FilmService;
import com.ness.movie_release_notifier.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class FilmController {

    @Autowired
    private FilmOmdbService filmOmdbService;

    @Autowired
    private FilmService filmService;

    @Autowired
    private UserService userService;

    @GetMapping("/getFilm")
    public String getFilm(@RequestParam("imdbId") String imdbId,
                        Model model){

        model.addAttribute("film", filmOmdbService.getInfo(imdbId));
        return "user/filmInfo";
    }

    @PostMapping("/subscribe")
    public String subscribe(@RequestParam(value = "imdbId") String imdbId,
                            Principal principal,
                            Model model){

        String login = principal.getName();

        User user = userService.findByLogin(login);
        OmdbFullWrapper wrapper = filmOmdbService.getInfo(imdbId);

        Film film = new Film(null,
                wrapper.getImdbId(),
                wrapper.getTitle(),
                wrapper.getReleased(),
                wrapper.getDvd(),
                user);

        filmService.save(film);

        model.addAttribute("user", login);
        model.addAttribute("film",
                wrapper.getTitle() + " (" + wrapper.getYear() + " )");

        return "user/subsConfirm";
    }
}
