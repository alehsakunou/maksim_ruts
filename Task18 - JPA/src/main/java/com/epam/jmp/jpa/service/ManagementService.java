package com.epam.jmp.jpa.service;

import com.epam.jmp.jpa.domain.Employee;
import com.epam.jmp.jpa.domain.Project;
import com.epam.jmp.jpa.domain.Unit;

/**
 * Created by Maksim Ruts on 11/3/2016.
 */
public interface ManagementService {
    void assignEmployeeToProject(Employee employee, Project project);
    void addEmployeeToUnit(Employee employee, Unit unit);
}
