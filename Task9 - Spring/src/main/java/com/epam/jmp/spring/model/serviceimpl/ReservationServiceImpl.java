package com.epam.jmp.spring.model.serviceimpl;

import com.epam.jmp.spring.model.dao.ReservationDao;
import com.epam.jmp.spring.model.domain.Reservation;
import com.epam.jmp.spring.model.domain.User;
import com.epam.jmp.spring.model.service.ReservationService;
import com.epam.jmp.spring.model.utils.ReservationNumberGenerationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by Gambit on 9/1/2016.
 */
@Service
public class ReservationServiceImpl extends AbstractGenericServiceImpl<Reservation, ReservationDao> implements ReservationService {

    @Autowired
    protected ReservationServiceImpl(ReservationDao dao) {
        super(dao);
    }

    @Autowired
    private ReservationNumberGenerationStrategy reservationNumberGenerationStrategy;


    @Override
    public Reservation create(User user, String movie, LocalDateTime dateTime, int seat, BigDecimal amount) {
        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setMovie(movie);
        reservation.setDateTime(dateTime);
        reservation.setSeat(seat);
        reservation.setAmount(amount);
        reservation.setNumber(reservationNumberGenerationStrategy.generate(reservation, user));
        return save(reservation);
    }
}
