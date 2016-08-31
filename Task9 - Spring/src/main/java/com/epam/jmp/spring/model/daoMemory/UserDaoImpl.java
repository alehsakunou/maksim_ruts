package com.epam.jmp.spring.model.daomemory;

import com.epam.jmp.spring.model.dao.UserDao;
import com.epam.jmp.spring.model.domain.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Gambit on 8/31/2016.
 * implementation of AbstractGenericDaoImpl for User domain object
 */
@Repository
public class UserDaoImpl extends AbstractGenericDaoImpl<User> implements UserDao {
    @Override
    public User readByName(String name) {
        return BASE.values()
                .stream()
                .filter(user -> name.equals(user.getFirstName()))
                .findFirst()
                .orElse(null);
    }

    @Override
    protected Class<User> getType() {
        return User.class;
    }
}
