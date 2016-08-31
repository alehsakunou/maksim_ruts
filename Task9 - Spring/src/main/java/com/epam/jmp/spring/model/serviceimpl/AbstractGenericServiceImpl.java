package com.epam.jmp.spring.model.serviceimpl;

import com.epam.jmp.spring.model.dao.GenericDao;
import com.epam.jmp.spring.model.domain.DomainObject;
import com.epam.jmp.spring.model.service.GenericService;

import java.util.Collection;

/**
 * Created by Gambit on 9/1/2016.
 */
public abstract class AbstractGenericServiceImpl<T extends DomainObject, SR extends GenericDao<Long, T>> implements GenericService<T> {
    private SR dao;

    protected AbstractGenericServiceImpl(SR dao) {
        this.dao = dao;
    }

    protected SR getDao() {
        return dao;
    }

    @Override
    public T save(T object) {
        Long id;
        if (object.getId() == null) {
            id = dao.create(object);
        } else {
            dao.update(object);
            id = object.getId();
        }
        return dao.read(id);
    }

    @Override
    public void remove(T object) {
        dao.delete(object);
    }

    @Override
    public T getById(Long id) {
        return dao.read(id);
    }

    @Override
    public Collection<T> getAll() {
        return dao.getAll();
    }
}
