package com.epam.jmp.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Maksim Ruts on 11/1/2016.
 * Domain object entity
 */
@Getter
@Setter
@MappedSuperclass
public class DomainObject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
