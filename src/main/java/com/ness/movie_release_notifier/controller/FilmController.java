package com.ness.movie_release_notifier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class FilmController {

    @GetMapping("/getFilm")
    public void getFilm(@RequestParam("imdbId") String imdbId){


    }
}
