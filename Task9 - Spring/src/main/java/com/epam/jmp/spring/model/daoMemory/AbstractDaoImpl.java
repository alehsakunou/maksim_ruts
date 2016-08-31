package com.epam.jmp.spring.model.daoMemory;

import com.epam.jmp.spring.model.dao.GenericDao;
import com.epam.jmp.spring.model.domain.DomainObject;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gambit on 8/31/2016.
 */
public abstract class AbstractDaoImpl<T extends DomainObject> implements GenericDao<Long, T> {
    protected final Map<Long, T> BASE;
    private Long currentId;

    {
        BASE = new HashMap<>();
        currentId = 0L;
    }

    @Override
    public Long create(T object) {
        Long id = generateId();
        object.setId(id);
        BASE.put(id, object);
        return id;
    }

    @Override
    public T read(Long id) {
        return BASE.get(id);
    }

    @Override
    public void update(T object) {
        BASE.put(object.getId(), object);
    }

    @Override
    public void delete(T object) {
        BASE.remove(object.getId());
    }

    @Override
    public Collection<T> getAll() {
        return BASE.values();
    }

    private Long generateId() {
        return currentId++;
    }
}
