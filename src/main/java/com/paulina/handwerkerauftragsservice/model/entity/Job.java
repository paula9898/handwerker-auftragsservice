package com.paulina.handwerkerauftragsservice.model.entity;

import com.paulina.handwerkerauftragsservice.model.entity.base.BaseEntity;
import com.paulina.handwerkerauftragsservice.model.enums.JobStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Job extends BaseEntity {
    private String title;
    private String description;
    private JobStatus status;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Employee employee;
}
