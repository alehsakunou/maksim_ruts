package com.epam.jmp.spring.model.daoMemory;

import com.epam.jmp.spring.model.dao.UserDao;
import com.epam.jmp.spring.model.domain.User;

/**
 * Created by Gambit on 8/31/2016.
 */
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {
    @Override
    public User readByName(String name) {
        return BASE.values()
                .stream()
                .filter(user -> name.equals(user.getFirstName()))
                .findFirst()
                .orElse(null);
    }
}
