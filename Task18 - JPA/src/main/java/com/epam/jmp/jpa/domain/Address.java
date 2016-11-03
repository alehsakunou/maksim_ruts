package com.epam.jmp.jpa.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Maksim Ruts on 11/1/2016.
 * Address entity
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class Address extends DomainObject {
    @Column
    private String index;
    @Column
    private String country;
    @Column
    private String state;
    @Column
    private String city;
}
