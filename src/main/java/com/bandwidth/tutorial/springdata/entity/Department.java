package com.bandwidth.tutorial.springdata.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "departments")
public class Department {
    @Id private String deptNo;
    @Column(nullable = false) private String deptName;
    @OneToMany(mappedBy = "department") private Set<EmployeeTenure> employeeTenures;
    @OneToMany(mappedBy = "department") private Set<ManagerTenure> managerTenures;
}
