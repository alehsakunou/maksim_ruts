package com.epam.jmp.spring.model.daomemory;

import com.epam.jmp.spring.model.dao.GenericDao;
import com.epam.jmp.spring.model.domain.DomainObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gambit on 8/31/2016.
 * Basic implementation of GenericDao interface
 */
public abstract class AbstractGenericDaoImpl<T extends DomainObject> implements GenericDao<Long, T> {
    private static final Logger LOGGER = LogManager.getLogger();
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
        LOGGER.info("created new {}: {}", getType().getSimpleName(), object);
        return id;
    }

    @Override
    public T read(Long id) {
        return BASE.get(id);
    }

    @Override
    public void update(T object) {
        BASE.put(object.getId(), object);
        LOGGER.info("updated {}: {}", getType().getSimpleName(), object);
    }

    @Override
    public void delete(T object) {
        BASE.remove(object.getId());
        LOGGER.info("deleted {}: {}", getType().getSimpleName(), object);
    }

    @Override
    public Collection<T> getAll() {
        return BASE.values();
    }

    private Long generateId() {
        return currentId++;
    }

    /**
     * Getting basic logger
     * @return basic logger
     */
    protected Logger getLogger() {
        return LOGGER;
    }

    /**
     * Getting type of domain object for DAO implementation
     * @return type of domain object
     */
    protected abstract Class<T> getType();
}
