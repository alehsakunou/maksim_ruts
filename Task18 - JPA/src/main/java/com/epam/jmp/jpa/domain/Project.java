package com.epam.jmp.jpa.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maksim Ruts on 11/1/2016.
 * Project entity
 */
@Getter
@Setter
@EqualsAndHashCode(doNotUseGetters = true, exclude = "employees", callSuper = false)
@Entity
public class Project extends DomainObject {
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String location;
    @Column
    private String owner;
    @ManyToMany
    @JoinTable(
            name = "project_staff",
            joinColumns = @JoinColumn(name = "project_fk"),
            inverseJoinColumns = @JoinColumn(name = "employee_fk")
    )
    private List<Employee> employees = new ArrayList<>();
}
