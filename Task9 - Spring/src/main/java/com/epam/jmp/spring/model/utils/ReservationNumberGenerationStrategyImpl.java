package com.epam.jmp.spring.model.utils;

import com.epam.jmp.spring.model.domain.Reservation;
import com.epam.jmp.spring.model.domain.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by Gambit on 9/1/2016.
 * HashCode implementation of strategy interface for generating reservation numbers
 */
@Component
public class ReservationNumberGenerationStrategyImpl implements ReservationNumberGenerationStrategy {
    @Override
    public String generate(Reservation reservation, User user) {
        int number = reservation.hashCode() * 100000 + user.hashCode() * 1000 + LocalDateTime.now().hashCode();
        return String.valueOf(Math.abs(number));
    }
}
