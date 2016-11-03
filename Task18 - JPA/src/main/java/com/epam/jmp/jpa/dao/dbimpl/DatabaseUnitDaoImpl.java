package com.epam.jmp.jpa.dao.dbimpl;

import com.epam.jmp.jpa.dao.UnitDao;
import com.epam.jmp.jpa.domain.Unit;
import org.springframework.stereotype.Repository;

/**
 * Created by Maksim Ruts on 11/3/2016.
 * Database implementation of DAO for unit
 */
@Repository
public class DatabaseUnitDaoImpl extends DatabaseGenericDaoImpl<Unit> implements UnitDao {
    @Override
    protected Class<Unit> getType() {
        return Unit.class;
    }
}
