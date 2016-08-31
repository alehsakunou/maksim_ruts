package com.epam.jmp.spring.model.daomemory;

import com.epam.jmp.spring.model.dao.ReservationDao;
import com.epam.jmp.spring.model.domain.Reservation;
import org.springframework.stereotype.Repository;

/**
 * Created by Gambit on 8/31/2016.
 * implementation of AbstractGenericDaoImpl for reservation domain object
 */
@Repository
public class ReservationDaoImpl extends AbstractGenericDaoImpl<Reservation> implements ReservationDao {
    @Override
    protected Class<Reservation> getType() {
        return Reservation.class;
    }
}
