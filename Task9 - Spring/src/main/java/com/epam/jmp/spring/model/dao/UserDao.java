package com.epam.jmp.spring.model.dao;

import com.epam.jmp.spring.model.domain.User;

/**
 * Created by Gambit on 8/31/2016.
 * DAO interface for User domain object
 */
public interface UserDao extends GenericDao<Long, User> {
    /**
     * Reading user by name from storage
     * @param name name of user
     * @return user
     */
    User readByName(String name);
}
