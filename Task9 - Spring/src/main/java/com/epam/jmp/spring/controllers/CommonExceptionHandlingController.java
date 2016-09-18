package com.epam.jmp.spring.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Maksim_Ruts on 8/18/2016.
 * Controller for exceptions handling
 */
@ControllerAdvice
public class CommonExceptionHandlingController {

    @ExceptionHandler(Exception.class)
    public ModelAndView errorsHandling(HttpServletRequest req, Exception ex) {
        ModelAndView mav = new ModelAndView("exceptions");
        mav.addObject("type", "common");
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        return mav;
    }
}
