package com.epam.jmp.spring.controllers;

import com.epam.jmp.spring.model.domain.User;
import com.epam.jmp.spring.model.facade.BookingFacade;
import com.epam.jmp.spring.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by Gambit on 9/19/2016.
 * Controller for manage tickets booking
 */
@Controller
@RequestMapping("/book")
@Scope("session")
public class BookingController {
    @Autowired
    private BookingFacade bookingFacade;

    /**
     * Book tickets method mapping
     * @param movie movie
     * @param date date
     * @param time time
     * @param seat seat
     * @param amount amount
     * @return view
     */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView book(
            @RequestParam(value = "movie") String movie,
            @RequestParam(value = "date") String date,
            @RequestParam(value = "time") String time,
            @RequestParam(value = "seat") int seat,
            @RequestParam(value = "amount") double amount) {

        String username = getUsername();
        User user = bookingFacade.login(username);
        bookingFacade.book(
                user,
                movie,
                LocalDateTime.of(LocalDate.parse(date), LocalTime.parse(time)),
                seat,
                BigDecimal.valueOf(amount));

        return new ModelAndView("booking")
                .addObject("message", "Ticket purchased! Want more?")
                .addObject("username", getUsername());
    }

    /**
     * Mapping for request to booking page
     * @return view
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView book() {
        return new ModelAndView("booking").addObject("username", getUsername());
    }

    private String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }
}
