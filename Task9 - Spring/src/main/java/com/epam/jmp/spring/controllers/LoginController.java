package com.epam.jmp.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Gambit on 9/19/2016.
 * Login controller
 */
@Controller
public class LoginController {
    /**
     * Mapping for login method
     * @param error error flag
     * @param logout logout flag
     * @return view
     */
    @RequestMapping("/login")
    public ModelAndView login (
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("message", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;
    }
}
