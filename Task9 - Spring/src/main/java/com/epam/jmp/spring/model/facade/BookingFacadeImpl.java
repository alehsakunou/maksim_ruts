package com.epam.jmp.spring.model.facade;

import com.epam.jmp.spring.model.domain.User;
import com.epam.jmp.spring.model.service.ReservationService;
import com.epam.jmp.spring.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by Gambit on 9/1/2016.
 * Implementation of business booking facade
 */
@Service
public class BookingFacadeImpl implements BookingFacade {
    @Autowired
    private UserService userService;

    @Autowired
    private ReservationService reservationService;

    @Override
    public User login(String firstName, String secondName) {
        User userByName = userService.getUserByName(firstName);
        return userByName == null ? userService.create(firstName, secondName) : userByName;
    }

    @Override
    public String book(User user, String movie, LocalDateTime dateTime, int seat, BigDecimal amount) {
        return reservationService.create(user, movie, dateTime, seat, amount).getNumber();
    }

    @Override
    public String book(String firstName, String secondName, String movie, LocalDateTime dateTime, int seat, BigDecimal amount) {
       return book(login(firstName, secondName), movie, dateTime, seat, amount);
    }
}
