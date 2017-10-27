package com.bandwidth.tutorial.springdata.repository;

import org.springframework.data.repository.CrudRepository;

import com.bandwidth.tutorial.springdata.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, String> {
    Department findByDeptName(String deptName);
}
