package com.bandwidth.tutorial.springdata.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
    @Id private Long empNo;
    @Temporal(TemporalType.DATE) @Column(nullable = false) private Date birthDate;
    @Column(nullable = false) private String firstName;
    @Column(nullable = false) private String lastName;
    @Enumerated(EnumType.STRING) @Column(nullable = false) private Gender gender;
    @Temporal(TemporalType.DATE) @Column(nullable = false) private Date hireDate;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER) private Set<Title> titles = new HashSet<>();
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER) private Set<Salary> salaries = new HashSet<>();
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER) private Set<EmployeeTenure> employeeTenures = new HashSet<>();
}
