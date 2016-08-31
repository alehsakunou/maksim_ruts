package com.epam.jmp.spring.model.daoMemory;

import com.epam.jmp.spring.model.dao.ReservationDao;
import com.epam.jmp.spring.model.domain.Reservation;
import org.springframework.stereotype.Repository;

/**
 * Created by Gambit on 8/31/2016.
 */
@Repository
public class ReservationDaoImpl extends AbstractDaoImpl<Reservation> implements ReservationDao {
}
