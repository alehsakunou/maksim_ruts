package com.epam.jmp.spring.integration;

import com.epam.jmp.spring.configuration.BasicConfiguration;
import com.epam.jmp.spring.model.facade.BookingFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by Gambit on 9/1/2016.
 * Common business flow
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BasicConfiguration.class)
public class BookingFlowTest {
    @Autowired
    private BookingFacade bookingFacade;

    @Test
    public void testFlow() throws Exception {
        bookingFacade.book("James", "Bond", "Skyfall", LocalDateTime.now(), 1, BigDecimal.ONE);
    }
}
