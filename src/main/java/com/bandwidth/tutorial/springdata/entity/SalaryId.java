package com.bandwidth.tutorial.springdata.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class SalaryId implements Serializable {
    private Long empNo;
    @Temporal(TemporalType.DATE) private Date fromDate;
}
