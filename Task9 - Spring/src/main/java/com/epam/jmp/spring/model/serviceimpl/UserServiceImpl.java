package com.epam.jmp.spring.model.serviceimpl;

import com.epam.jmp.spring.model.dao.UserDao;
import com.epam.jmp.spring.model.domain.User;
import com.epam.jmp.spring.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Gambit on 9/1/2016.
 */
@Service
public class UserServiceImpl extends AbstractGenericServiceImpl<User, UserDao> implements UserService {
    @Autowired
    protected UserServiceImpl(UserDao dao) {
        super(dao);
    }

    @Override
    public User getUserByName(String name) {
        return getDao().readByName(name);
    }

    @Override
    public User create(String firstName, String secondName) {
        return save(new User(firstName, secondName));
    }
}
