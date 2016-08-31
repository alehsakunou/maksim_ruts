package com.epam.jmp.spring.model.utils;

import com.epam.jmp.spring.model.domain.Reservation;
import com.epam.jmp.spring.model.domain.User;

/**
 * Created by Gambit on 9/1/2016.
 * Strategy interface for generating reservation numbers
 */
public interface ReservationNumberGenerationStrategy {
    String generate(Reservation reservation, User user);
}
