package com.epam.jmp.jpa.service;

import com.epam.jmp.jpa.dao.GenericDao;
import com.epam.jmp.jpa.domain.DomainObject;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Maksim Ruts on 11/3/2016.
 */
@Transactional
public abstract class GenericServiceImpl<T extends DomainObject, D extends GenericDao<T, Long>> implements GenericService<T> {
    @Override
    public void create(T object) {
        getDao().create(object);
    }

    @Override
    public T read(Long id) {
        return getDao().read(id);
    }

    @Override
    public void update(T object) {
        getDao().update(object);
    }

    @Override
    public void delete(T object) {
        getDao().delete(object);
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }

    protected abstract D getDao();
}
