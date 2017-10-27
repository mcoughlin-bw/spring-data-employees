package com.bandwidth.tutorial.springdata.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class TenureId implements Serializable {
    private Long empNo;
    private String deptNo;
}
