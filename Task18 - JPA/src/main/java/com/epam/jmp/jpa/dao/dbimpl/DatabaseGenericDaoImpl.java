package com.epam.jmp.jpa.dao.dbimpl;

import com.epam.jmp.jpa.dao.GenericDao;
import com.epam.jmp.jpa.domain.DomainObject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Maksim Ruts on 11/3/2016.
 * Generic database DAO implementation
 */
public abstract class DatabaseGenericDaoImpl<T extends DomainObject> implements GenericDao<T, Long> {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(T object) {
        getSession().save(object);
    }

    @Override
    public T read(Long id) {
        return (T) getSession().get(getType(), id);
    }

    @Override
    public void update(T object) {
        getSession().update(object);
    }

    @Override
    public void delete(T object) {
        getSession().delete(object);
    }

    @Override
    public List<T> findAll() {
        return getSession().createCriteria(getType()).list();
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected abstract Class<T> getType();
}
