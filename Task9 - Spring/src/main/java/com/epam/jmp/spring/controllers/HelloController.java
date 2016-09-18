package com.epam.jmp.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Gambit on 9/18/2016.
 * Start page controller
 */
@Controller
public class HelloController {
    /**
     * Start page mapping
     * @return view
     */
    @RequestMapping("/")
    public String hello() {
        return "hello";
    }
}
