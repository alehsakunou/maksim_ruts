package com.epam.jmp.jpa.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maksim Ruts on 11/1/2016.
 * Employee entity
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(doNotUseGetters = true, exclude = "projects", callSuper = false)
public class Employee extends DomainObject {
    @Column
    private String firstName;
    @Column
    private String lastName;
    @OneToOne
    private Address address;
    @ManyToMany(mappedBy = "employees")
    private List<Project> projects = new ArrayList<>();
}
