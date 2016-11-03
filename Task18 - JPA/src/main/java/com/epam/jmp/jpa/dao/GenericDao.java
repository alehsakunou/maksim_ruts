package com.epam.jmp.jpa.dao;

import com.epam.jmp.jpa.domain.DomainObject;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Maksim Ruts on 11/3/2016.
 * Generic DAO interface
 */
public interface GenericDao<T extends DomainObject, PK extends Serializable> {
    /**
     * Create object
     * @param object object to create
     */
    void create(T object);

    /**
     * Read object by id
     * @param id id of object
     * @return requested object
     */
    T read(PK id);

    /**
     * Update object
     * @param object object for update
     */
    void update(T object);

    /**
     * Delete object
     * @param object object for deleting
     */
    void delete(T object);

    /**
     * Find all objects
     * @return list of all objects
     */
    List<T> findAll();
}
