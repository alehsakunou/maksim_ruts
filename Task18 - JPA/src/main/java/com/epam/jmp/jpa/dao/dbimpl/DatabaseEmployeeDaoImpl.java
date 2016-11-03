package com.epam.jmp.jpa.dao.dbimpl;

import com.epam.jmp.jpa.dao.EmployeeDao;
import com.epam.jmp.jpa.domain.Employee;
import org.springframework.stereotype.Repository;

/**
 * Created by Maksim Ruts on 11/3/2016.
 * Database implementation of DAO for employee
 */
@Repository
public class DatabaseEmployeeDaoImpl extends DatabaseGenericDaoImpl<Employee> implements EmployeeDao {
    @Override
    protected Class<Employee> getType() {
        return Employee.class;
    }
}
