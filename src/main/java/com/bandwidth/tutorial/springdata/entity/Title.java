package com.bandwidth.tutorial.springdata.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "titles")
public class Title {
    @EmbeddedId private TitleId id;
    @MapsId("empNo") @ManyToOne @JoinColumn(name = "emp_no") private Employee employee;
    @Temporal(TemporalType.DATE) @Column(nullable = false) private Date toDate;
}
