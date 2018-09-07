package com.ness.movie_release_notifier.controller;

import com.ness.movie_release_notifier.model.Film;
import com.ness.movie_release_notifier.model.OmdbFullWrapper;
import com.ness.movie_release_notifier.model.User;
import com.ness.movie_release_notifier.service.FilmOmdbService;
import com.ness.movie_release_notifier.service.FilmService;
import com.ness.movie_release_notifier.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
                          Principal principal,
                          Model model){

        User user = userService.findByLogin(principal.getName());

        if (filmService.isExistsByImdbIdAndUserId(imdbId, user.getId())) {
            model.addAttribute("subscribed", true);
        }
        model.addAttribute("film", filmOmdbService.getInfo(imdbId));
        return "user/filmInfo";
    }

    @PostMapping("/subscribe")
    public String subscribe(@RequestParam(value = "imdbId") String imdbId,
                            Principal principal,
                            Model model){

        String login = principal.getName();

        User user = userService.findByLogin(login);

        if(filmService.isExistsByImdbIdAndUserId(imdbId, user.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT);

        OmdbFullWrapper wrapper = filmOmdbService.getInfo(imdbId);

        if (wrapper == null)
            throw new ResponseStatusException(HttpStatus.CONFLICT);

        Film film = new Film(null,
                wrapper.getImdbId(),
                wrapper.getTitle(),
                wrapper.getReleased(),
                wrapper.getDvd(),
                user);

        filmService.save(film);

        return "redirect:getFilm?imdbId=" + imdbId;
    }

    @PostMapping("/unSubscribe")
    public String unSubscribe(@RequestParam(value = "imdbId") String imdbId,
                            Principal principal){

        String login = principal.getName();

        User user = userService.findByLogin(login);

        filmService.getByImdbIdAndUserId(imdbId, user.getId()).forEach(filmService::delete);

        return "redirect:getFilm?imdbId=" + imdbId;
    }
}
