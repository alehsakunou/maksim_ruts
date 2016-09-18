package com.epam.jmp.spring.listener;

import com.epam.jmp.spring.model.domain.User;
import com.epam.jmp.spring.model.service.UserService;
import com.epam.jmp.spring.sequrity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by Gambit on 8/15/2016.
 * Listener for user creating on startup
 */
@Component
public class CreateUsersApplicationListenerBean implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent applicationEvent) {
        prepareUsers();
    }

    private void prepareUsers() {
        User user = new User();
        user.setFirstName("Bruce");
        user.setLastName("Wayne");
        user.setPassword(passwordEncoder.encode("pass"));
        user.addRole(Role.ROLE_REGISTERED_USER);
        user.addRole(Role.ROLE_BOOKING_MANAGER);

        userService.save(user);
    }

}
