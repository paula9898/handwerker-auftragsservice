package com.paulina.handwerkerauftragsservice.model.entity;

import com.paulina.handwerkerauftragsservice.model.entity.base.BaseEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Customer extends BaseEntity {
    private String firstname;
    private String surname;
    private String phone;
    private String email;
    @Embedded
    private Address address;
}
