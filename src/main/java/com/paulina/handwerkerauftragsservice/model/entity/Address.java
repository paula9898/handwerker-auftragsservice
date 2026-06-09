package com.paulina.handwerkerauftragsservice.model.entity;

import com.paulina.handwerkerauftragsservice.model.entity.base.BaseEntity;

import java.util.UUID;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Embeddable
public class Address {
    private String name;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
}
