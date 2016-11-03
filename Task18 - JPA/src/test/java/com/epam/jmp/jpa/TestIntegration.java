package com.epam.jmp.jpa;

import com.epam.jmp.jpa.config.ApplicationConfig;
import com.epam.jmp.jpa.domain.Address;
import com.epam.jmp.jpa.domain.Employee;
import com.epam.jmp.jpa.domain.Project;
import com.epam.jmp.jpa.domain.Unit;
import com.epam.jmp.jpa.service.EmployeeService;
import com.epam.jmp.jpa.service.ManagementService;
import com.epam.jmp.jpa.service.ProjectService;
import com.epam.jmp.jpa.service.UnitService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Maksim Ruts on 11/3/2016.
 * Test flow
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class TestIntegration {
    @Autowired
    private ManagementService managementService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UnitService unitService;


    /**
     * Main test method
     * @throws Exception exception
     */
    @Test
    @Transactional
    public void testLogic() throws Exception {
        Address address = new Address();
        address.setCity("Gotham");
        address.setCountry("Land");
        address.setState("st");
        address.setIndex("666");

        Employee employee = new Employee();
        employee.setFirstName("Bruce");
        employee.setLastName("Wayne");
        employee.setAddress(address);
        employeeService.create(employee);

        Project project = new Project();
        project.setName("Archam cleaning");
        project.setDescription("destroy all busters from Archam");
        project.setLocation("Archam");
        project.setOwner("Wayne inc.");
        projectService.create(project);

        Unit unit = new Unit();
        unit.setDescription("Justice League");
        unit.setDescription("Guards of world");
        unitService.create(unit);

        managementService.addEmployeeToUnit(employee, unit);
        managementService.assignEmployeeToProject(employee, project);
    }
}
