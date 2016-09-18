package com.epam.jmp.spring.sequrity;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Gambit on 8/25/2016.
 * Roles for Spring Security
 */
public enum Role implements GrantedAuthority {
    ROLE_REGISTERED_USER,
    ROLE_BOOKING_MANAGER;

    @Override
    public String getAuthority() {
        return this.name().toUpperCase();
    }
}
