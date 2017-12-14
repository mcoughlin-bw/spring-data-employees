package com.bandwidth.tutorial.springdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bandwidth.tutorial.springdata.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, String> {
    Department findByDeptName(String deptName);

    @Query(" select d from Department d join fetch d.employeeTenures et join fetch et.employee where d.deptName = :deptName")
    Department findWithEmployeesByDeptName_excessiveFetching(@Param("deptName") String deptName);

    @Query("select d.deptName, sum(s.salary) " +
        "from Department d " +
        "join d.employeeTenures et " +
        "join et.employee e " +
        "join e.salaries s " +
        "where current_date between s.id.fromDate and s.toDate " +
        "group by d.deptName")
    List findSumOfEmployeeSalaries();

    @Query(nativeQuery = true, value = "select d.dept_name, sum(s.salary) " +
        "from departments d " +
        "join dept_emp de on de.dept_no = d.dept_no " +
        "join employees e on e.emp_no = de.emp_no " +
        "join salaries s on s.emp_no = e.emp_no " +
        "where current_date between s.from_date and s.to_date " +
        "group by d.dept_name")
    List findSumOfEmployeeSalaries_native();
}
