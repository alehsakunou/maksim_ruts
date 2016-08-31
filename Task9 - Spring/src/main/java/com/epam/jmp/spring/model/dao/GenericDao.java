package com.epam.jmp.spring.model.dao;

import java.util.Collection;

/**
 * Created by Gambit on 8/31/2016.
 */
public interface GenericDao<PK, T> {
    PK create(T object);
    T read(PK id);
    void update(T object);
    void delete(T object);
    Collection<T> getAll();
}