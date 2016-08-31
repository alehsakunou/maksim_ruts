package com.epam.jmp.spring.model.daomemory;

import com.epam.jmp.spring.model.domain.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Gambit on 8/31/2016.
 * Test for User DAO
 */
public class UserDaoImplTest {

    private UserDaoImpl userDao;

    @Before
    public void setUp() throws Exception {
        userDao = new UserDaoImpl();

    }

    @Test
    public void readByName() throws Exception {
        User user = new User("James", "Bond");
        userDao.create(user);
        User newUser = userDao.readByName(user.getFirstName());
        assertEquals(user, newUser);
    }
}