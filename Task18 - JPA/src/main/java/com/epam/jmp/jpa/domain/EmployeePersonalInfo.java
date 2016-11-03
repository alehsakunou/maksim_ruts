package com.epam.jmp.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

/**
 * Created by Maksim Ruts on 11/1/2016.
 * Employee personal info entity
 */
@Entity
@Getter
@Setter
public class EmployeePersonalInfo extends DomainObject {
    @Column
    private String info;
    @Enumerated
    @Column
    private EmployeeStatus status;
}
