package com.epam.jmp.spring.sequrity;

import com.epam.jmp.spring.model.dao.UserDao;
import com.epam.jmp.spring.model.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Gambit on 8/25/2016.
 * User details service for Spring Security
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.readByName(s);

        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(
                        user.getFirstName(),
                        user.getPassword(),
                        user.getRoles());
        return userDetails;
    }
}
