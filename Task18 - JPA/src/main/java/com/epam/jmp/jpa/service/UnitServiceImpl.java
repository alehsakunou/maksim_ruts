package com.epam.jmp.jpa.service;

import com.epam.jmp.jpa.dao.UnitDao;
import com.epam.jmp.jpa.domain.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Maksim Ruts on 11/3/2016.
 * Unit service implementation
 */
@Service
@Transactional
public class UnitServiceImpl extends GenericServiceImpl<Unit, UnitDao> implements UnitService {
    @Autowired
    private UnitDao unitDao;

    @Override
    protected UnitDao getDao() {
        return unitDao;
    }
}
