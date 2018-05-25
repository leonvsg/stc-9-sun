package ru.innopolis.stc9.sun.academy.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;
import ru.innopolis.stc9.sun.academy.dto.UserDTO;
import ru.innopolis.stc9.sun.academy.service.UserService;

@Controller
@RequestMapping("/signup")
public class SignUpController {
    private final UserService userService;

    private static final Logger LOGGER = Logger.getLogger(SignUpController.class);

    @Autowired
    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String signUp(ModelMap model) {
        model.addAttribute("user", new UserDTO());
        model.addAttribute("title", "Регистрация");
        return "signup";
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public RedirectView signUpSubmit(@ModelAttribute("user") final UserDTO user, ModelMap model) {
        userService.addUser(user);
        return new RedirectView("/");
    }
}
