package com.bandwidth.tutorial.springdata.repository;

import java.util.Iterator;
import java.util.Set;

import org.junit.Ignore;
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

    @Test(timeout = 5000)
    public void findByDeptName() {
        final Department departmentById = departmentRepository.findOne("d009");
        final Department departmentByName = departmentRepository.findByDeptName("Customer Service");

        assertEquals(departmentById, departmentByName);
    }

    @Test(timeout = 5000)
    @Ignore
    public void findWithEmployeesByDeptName_excessiveFetching() {
        departmentRepository.findWithEmployeesByDeptName_excessiveFetching("Customer Service");
    }

    @Test
    public void findSumOfEmployeeSalaries() {
        final Iterator<Object[]> hqlResultsIter = departmentRepository.findSumOfEmployeeSalaries().iterator();
        final Iterator<Object[]> mySqlResultsIter = departmentRepository.findSumOfEmployeeSalaries_native().iterator();

        while (hqlResultsIter.hasNext()) {
            final Object[] hqlResult = hqlResultsIter.next();
            final Object[] mySqlResult = mySqlResultsIter.next();
            assertEquals(hqlResult[0], mySqlResult[0]);
            assertEquals(hqlResult[1], mySqlResult[1]);
        }
    }
}
