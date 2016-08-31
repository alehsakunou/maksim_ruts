package com.epam.jmp.spring.model.service;

import com.epam.jmp.spring.model.domain.User;

/**
 * Created by Gambit on 9/1/2016.
 * Service interface for User domain object
 */
public interface UserService extends GenericService<User> {
    User getUserByName(String name);
    User create(String firstName, String secondName);
}
