package com.bandwidth.tutorial.springdata.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bandwidth.tutorial.springdata.entity.Department;

public class EmployeeTenureRepositoryTest extends RepositoryTest {
    @Autowired EmployeeTenureRepository employeeTenureRepository;
    @Autowired DepartmentRepository departmentRepository;

    //expected to timeout
    @Test(timeout = 5000)
    public void deleteByDepartmentDeptName() {
        final Department department = departmentRepository.findByDeptName("Customer Service");
        employeeTenureRepository.deleteByDepartment(department);
    }

    @Test(timeout = 5000)
    public void bulkDeleteByDepartmentDeptName() {
        final Department department = departmentRepository.findByDeptName("Customer Service");
        employeeTenureRepository.bulkDeleteByDepartment(department);
    }
}
