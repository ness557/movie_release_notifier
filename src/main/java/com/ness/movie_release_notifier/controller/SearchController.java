package com.ness.movie_release_notifier.controller;

import com.ness.movie_release_notifier.model.OmdbSearchResultWrapper;
import com.ness.movie_release_notifier.service.FilmOmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class SearchController {

    @Autowired
    private FilmOmdbService filmOmdbService;

    @GetMapping("/search")
    public String search(@RequestParam("query") String query,
                         @RequestParam(required = false, name = "year") Integer year,
                         @RequestParam(required = false, name = "page") Integer page,
                         Model model){

        OmdbSearchResultWrapper result;
        if(year != null && page != null)
            result = filmOmdbService.search(query, year, page);

        else if(page != null)
            result = filmOmdbService.search(query, page);

        else
            result = filmOmdbService.search(query);

        model.addAttribute("films", result.getFilms());
        model.addAttribute("pageCount", (int) Math.ceil(result.getTotalResults()/10.0));
        model.addAttribute("page", page);

        return "user/searchResult";
    }

}
