package ru.innopolis.stc9.sun.academy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping
    protected String index(ModelMap model) {
        model.addAttribute("title", "Главная");
        return "index";
    }
}
