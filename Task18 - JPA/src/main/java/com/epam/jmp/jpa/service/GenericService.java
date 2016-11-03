package com.epam.jmp.jpa.service;

import com.epam.jmp.jpa.domain.DomainObject;

import java.util.List;

/**
 * Created by Maksim Ruts on 11/3/2016.
 * Generic service
 */
public interface GenericService<T extends DomainObject> {
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
    T read(Long id);

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
