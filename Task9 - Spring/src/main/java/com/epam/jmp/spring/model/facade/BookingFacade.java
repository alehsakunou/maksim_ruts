package com.epam.jmp.spring.model.facade;

import com.epam.jmp.spring.model.domain.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by Gambit on 9/1/2016.
 * Business booking facade
 */
public interface BookingFacade {
    /**
     * Login to system
     * @param firstName user first name
     * @param secondName user last name
     * @return user domain object
     */
    User login(String firstName);

    /**
     * Booking reservation
     * @param user owner
     * @param movie movie
     * @param dateTime date of event
     * @param seat seat number
     * @param amount event amount
     * @return number of reservation
     */
    String book(User user, String movie, LocalDateTime dateTime, int seat, BigDecimal amount);

    /**
     * Booking reservation
     * @param firstName first name of owner
     * @param secondName second name of owner
     * @param movie movie
     * @param dateTime date of event
     * @param seat seat number
     * @param amount event amount
     * @return number of reservation
     */
    String book(String firstName, String secondName, String movie, LocalDateTime dateTime, int seat, BigDecimal amount);
}
