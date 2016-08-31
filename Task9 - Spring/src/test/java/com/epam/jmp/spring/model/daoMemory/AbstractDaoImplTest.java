package com.epam.jmp.spring.model.daoMemory;

import com.epam.jmp.spring.model.domain.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Gambit on 8/31/2016.
 */
public class AbstractDaoImplTest {
    private AbstractDaoImpl<User> abstractDao;

    @Before
    public void setUp() throws Exception {
        abstractDao = new AbstractDaoImpl<User>() {};
    }

    @Test
    public void testSimpleFlow() throws Exception {
        User user = new User("James", "Bond");
        user.setId(0L);

        abstractDao.create(user);
        User newUser = abstractDao.read(user.getId());
        assertEquals(user, newUser);
        user.setLastName("Born");
        abstractDao.update(user);
        User updatedUser = abstractDao.read(user.getId());
        assertEquals(user, updatedUser);
        abstractDao.delete(user);
        User deletedUser = abstractDao.read(user.getId());
        assertEquals(null, deletedUser);
    }
}