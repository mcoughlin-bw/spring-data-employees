package com.bandwidth.tutorial.springdata.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dept_manager")
public class ManagerTenure extends Tenure {
}
