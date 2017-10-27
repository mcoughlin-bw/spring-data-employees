package com.bandwidth.tutorial.springdata.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.MapsId;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
abstract class Tenure {
    @EmbeddedId private TenureId id;
    @MapsId("empNo") @ManyToOne @JoinColumn(name = "emp_no") private Employee employee;
    @MapsId("deptNo") @ManyToOne @JoinColumn(name = "dept_no") private Department department;
    @Temporal(TemporalType.DATE) @Column(nullable = false) private Date fromDate;
    @Temporal(TemporalType.DATE) @Column(nullable = false) private Date toDate;
}
