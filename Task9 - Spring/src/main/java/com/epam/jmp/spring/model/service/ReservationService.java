package com.epam.jmp.spring.model.service;

import com.epam.jmp.spring.model.domain.Reservation;
import com.epam.jmp.spring.model.domain.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by Gambit on 9/1/2016.
 * Service interface for Reservation domain object
 */
public interface ReservationService extends GenericService<Reservation> {

    Reservation create(User user, String movie, LocalDateTime dateTime, int seat, BigDecimal amount);
}
