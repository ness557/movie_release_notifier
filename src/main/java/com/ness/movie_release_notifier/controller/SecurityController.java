package com.ness.movie_release_notifier.controller;

import com.ness.movie_release_notifier.model.User;
import com.ness.movie_release_notifier.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class SecurityController {

    @Autowired
    private UserService service;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public ModelAndView registerForm() {
        return new ModelAndView("register")
                .addObject(new User());
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute User user,
                           BindingResult bindingResult) {

        if(bindingResult.hasErrors())
            return "register";

        user.setRole("USER");
        service.save(user);

        return "home";
    }
}
