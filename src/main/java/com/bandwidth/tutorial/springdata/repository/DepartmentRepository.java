package com.bandwidth.tutorial.springdata.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bandwidth.tutorial.springdata.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, String> {
    Department findByDeptName(String deptName);

    @Query(" select d from Department d join fetch d.employeeTenures et join fetch et.employee where d.deptName = :deptName")
    Department findWithEmployeesByDeptName_excessiveFetching(@Param("deptName") String deptName);
}
