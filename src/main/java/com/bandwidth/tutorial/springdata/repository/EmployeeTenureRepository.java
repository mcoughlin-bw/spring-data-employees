package com.bandwidth.tutorial.springdata.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bandwidth.tutorial.springdata.entity.Department;
import com.bandwidth.tutorial.springdata.entity.EmployeeTenure;
import com.bandwidth.tutorial.springdata.entity.TenureId;

public interface EmployeeTenureRepository extends CrudRepository<EmployeeTenure, TenureId> {

    int deleteByDepartment(Department department);

    @Modifying
    @Query("delete from EmployeeTenure et where et.department = ?1")
    int bulkDeleteByDepartment(Department department);
}
