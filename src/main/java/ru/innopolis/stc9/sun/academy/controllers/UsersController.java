package ru.innopolis.stc9.sun.academy.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.innopolis.stc9.sun.academy.dto.UserDTO;
import ru.innopolis.stc9.sun.academy.service.UserService;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {
    private static final Logger LOGGER = Logger.getLogger(UsersController.class);
    private static final String TITLE = "Пользователи";
    protected static final String REDIRECT_TO_USERS = "redirect:/users";
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsers(ModelMap model){
        model.addAttribute("title", TITLE);
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @PostMapping
    public String postUser(@Valid @ModelAttribute("user") final UserDTO user,
                           BindingResult bindingResult,
                           ModelMap model){
        return REDIRECT_TO_USERS;
    }

    @PostMapping("/add")
    public String addUser(ModelMap model){
        return REDIRECT_TO_USERS;
    }

    @PostMapping("/update")
    public String updateUser(ModelMap model){
        return REDIRECT_TO_USERS;
    }
}
