package com.epam.jmp.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maksim Ruts on 11/1/2016.
 * Unit entity
 */
@Entity
@Getter
@Setter
public class Unit extends DomainObject {
    @Column
    private String name;
    @Column
    private String description;
    @OneToMany
    @JoinTable(
            name = "units_employees",
            joinColumns = @JoinColumn(name = "employee_fk"),
            inverseJoinColumns = @JoinColumn(name = "unit_fk")
    )
    private List<Employee> employees = new ArrayList<>();
}
