package com.epam.jmp.spring.model.dao;

import java.util.Collection;

/**
 * Created by Gambit on 8/31/2016.
 * Common DAO interface
 */
public interface GenericDao<PK, T> {
    /**
     * Saving new object to storage
     * @param object object to save
     * @return primary key
     */
    PK create(T object);

    /**
     * Reading object from strogate
     * @param id primary key
     * @return object for key or <code>null</code>
     */
    T read(PK id);

    /**
     * Updating object at storage
     * @param object object for updating
     */
    void update(T object);

    /**
     * Deleting object from storage
     * @param object object to delete
     */
    void delete(T object);

    /**
     * Receiving collection of all objects from storage
     * @return collection of objects
     */
    Collection<T> getAll();
}