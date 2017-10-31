package com.bandwidth.tutorial.springdata.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.bandwidth.tutorial.springdata.entity.Employee;
import com.bandwidth.tutorial.springdata.entity.Gender;
import com.bandwidth.tutorial.springdata.entity.Salary;
import com.bandwidth.tutorial.springdata.entity.SalaryId;
import com.bandwidth.tutorial.springdata.entity.Title;
import com.bandwidth.tutorial.springdata.entity.TitleId;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class EmployeeRepositoryTest extends RepositoryTest {
    @Autowired EmployeeRepository employeeRepository;

    @Test
    public void crud() {
        final Employee employee = new Employee();
        employee.setEmpNo(99999L);
        employee.setFirstName("Michael");
        employee.setLastName("Coughlin");
        employee.setGender(Gender.M);
        employee.setBirthDate(new Date());
        employee.setHireDate(new Date());

        final Title title = new Title();
        title.setEmployee(employee);
        final TitleId titleId = new TitleId();
        titleId.setFromDate(new Date());
        title.setToDate(new Date());
        titleId.setTitle("President");
        title.setId(titleId);
        employee.getTitles().add(title);

        final Salary salary = new Salary();
        salary.setEmployee(employee);
        final SalaryId salaryId = new SalaryId();
        salaryId.setFromDate(new Date());
        salary.setToDate(new Date());
        salary.setId(salaryId);
        salary.setSalary(new BigDecimal(50000));
        employee.getSalaries().add(salary);

        final Employee savedEmployee = employeeRepository.save(employee);
        assertNotNull(savedEmployee);

        final Employee foundEmployee = employeeRepository.findOne(savedEmployee.getEmpNo());
        assertNotNull(foundEmployee);

        employeeRepository.delete(savedEmployee);
        assertNull(employeeRepository.findOne(savedEmployee.getEmpNo()));
    }

    @Test
    public void findByFirstNameAndLastName() {
        final List<Employee> employeesByName = employeeRepository.findByDepartmentAndTitle("Sales", "Manager");
        final Employee employee = employeesByName.get(0);
        assertFalse(CollectionUtils.isEmpty(employeesByName));

        //These collections are fetched automatically
        assertFalse(CollectionUtils.isEmpty(employee.getEmployeeTenures()));
        assertFalse(CollectionUtils.isEmpty(employee.getSalaries()));
        assertFalse(CollectionUtils.isEmpty(employee.getTitles()));
    }

    @Test
    public void findByDepartmentAndTitle() {
        final List<Employee> employeesByDepartmentAndTitle = employeeRepository.findByDepartmentAndTitle("Sales", "Manager");
        assertFalse(CollectionUtils.isEmpty(employeesByDepartmentAndTitle));
    }
}
