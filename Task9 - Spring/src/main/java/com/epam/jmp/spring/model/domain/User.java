package com.epam.jmp.spring.model.domain;

import com.epam.jmp.spring.sequrity.Role;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Gambit on 8/31/2016.
 * Domain user object
 */
public class User extends DomainObject {
    private static final String ROLE_SPLITTER = ",";
    private String firstName;
    private String lastName;
    private String password;
    private String roles;

    public User() {
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        List<Role> list = new ArrayList<>();
        for (String role : roles.split(ROLE_SPLITTER)) {
            list.add(Role.valueOf(role));
        }

        return list;
    }

    public void addRole(GrantedAuthority role) {
        if (this.roles == null) {
            this.roles = role.getAuthority();
        } else {
            this.roles += ROLE_SPLITTER + role.getAuthority();
        }
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return new EqualsBuilder()
                .append(firstName, user.firstName)
                .append(lastName, user.lastName)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(firstName)
                .append(lastName)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .toString();
    }
}
