package com.epam.jmp.jpa.service;

import com.epam.jmp.jpa.dao.EmployeeDao;
import com.epam.jmp.jpa.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Maksim Ruts on 11/3/2016.
 * Employee service implementation
 */
@Service
@Transactional
public class EmployeeServiceImpl extends GenericServiceImpl<Employee, EmployeeDao> implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    protected EmployeeDao getDao() {
        return employeeDao;
    }
}
