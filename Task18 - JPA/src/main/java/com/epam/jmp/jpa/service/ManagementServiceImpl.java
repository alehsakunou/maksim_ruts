package com.epam.jmp.jpa.service;

import com.epam.jmp.jpa.domain.Employee;
import com.epam.jmp.jpa.domain.Project;
import com.epam.jmp.jpa.domain.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Maksim Ruts on 11/3/2016.
 * Management service
 */
@Service
@Transactional
public class ManagementServiceImpl implements ManagementService {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UnitService unitService;

    /**
     * Assign epmployee to project
     * @param employee employee
     * @param project project
     */
    @Override
    public void assignEmployeeToProject(Employee employee, Project project) {
        project.getEmployees().add(employee);
        employee.getProjects().add(project);
        projectService.update(project);
        employeeService.update(employee);
    }

    /**
     * Add employee to unit
     * @param employee employee
     * @param unit unit
     */
    @Override
    public void addEmployeeToUnit(Employee employee, Unit unit) {
        unit.getEmployees().add(employee);
        unitService.update(unit);
        employeeService.update(employee);
    }
}
