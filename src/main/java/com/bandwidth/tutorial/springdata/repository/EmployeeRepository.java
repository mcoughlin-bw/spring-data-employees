package com.bandwidth.tutorial.springdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bandwidth.tutorial.springdata.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);

    @Query("select e from Employee e join e.employeeTenures et join et.department d join e.titles t where d.deptName = :department and t.id.title = :title")
    List<Employee> findByDepartmentAndTitle(@Param("department") String department, @Param("title") String title);
}
