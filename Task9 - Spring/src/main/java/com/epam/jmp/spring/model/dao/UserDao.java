package com.epam.jmp.spring.model.dao;

import com.epam.jmp.spring.model.domain.User;

/**
 * Created by Gambit on 8/31/2016.
 */
public interface UserDao extends GenericDao<Long, User> {
    User readByName(String name);
}
