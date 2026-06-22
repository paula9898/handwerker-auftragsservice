package com.paulina.handwerkerauftragsservice.model.entity;

import com.paulina.handwerkerauftragsservice.model.entity.base.BaseEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
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
public class Employee extends BaseEntity {
    private String firstName;
    private String surname;
    private String phone;
    private String email;
    private String specialization;
    @Embedded
    private Address address;
}
