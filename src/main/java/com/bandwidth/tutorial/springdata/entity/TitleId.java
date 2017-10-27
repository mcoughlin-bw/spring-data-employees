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
public class TitleId implements Serializable {
    private Long empNo;
    private String title;
    @Temporal(TemporalType.DATE) private Date fromDate;
}
