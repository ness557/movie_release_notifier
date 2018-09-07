package com.ness.movie_release_notifier.controller;

import com.ness.movie_release_notifier.model.User;
import com.ness.movie_release_notifier.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SecurityController {

    @Autowired
    private UserService service;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {

        model.addAttribute(new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute User user,
                           BindingResult bindingResult, Model model) {

        List<String> errors = new ArrayList<>();

        if(user.getEmail().isEmpty() && user.getTelegramId().isEmpty())
            errors.add("Please enter email or telegram id");

        if (user.getId() == null)
            if(service.isExists(user.getLogin()))
                errors.add("User with such login already exists");


        if(!errors.isEmpty()){
            model.addAttribute("errors", errors);
            return "register";
        }

        if(bindingResult.hasErrors())
            return "register";

        user.setRole("ROLE_USER");
        service.save(user);

        return "home";
    }

    @GetMapping("/userInfo")
    public String userInfo(Model model, Principal principal){

        model.addAttribute(service.findByLogin(principal.getName()));
        return "register";
    }
}
