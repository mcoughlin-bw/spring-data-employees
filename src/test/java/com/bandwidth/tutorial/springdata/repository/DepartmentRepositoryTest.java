package com.bandwidth.tutorial.springdata.repository;

import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bandwidth.tutorial.springdata.entity.Department;
import com.bandwidth.tutorial.springdata.entity.ManagerTenure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DepartmentRepositoryTest extends RepositoryTest {
    @Autowired DepartmentRepository departmentRepository;

    @Test
    public void crud() {
        final Department department = departmentRepository.findOne("d009");
        final Set<ManagerTenure> managerTenures = department.getManagerTenures();
        assertNotNull(managerTenures);
    }

    @Test
    public void findTest() {
        final Department departmentById = departmentRepository.findOne("d009");
        final Department departmentByName = departmentRepository.findByDeptName("Customer Service");

        assertEquals(departmentById, departmentByName);
    }
}
