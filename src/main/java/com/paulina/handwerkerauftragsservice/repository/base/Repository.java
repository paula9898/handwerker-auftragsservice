package com.paulina.handwerkerauftragsservice.repository.base;

import com.paulina.handwerkerauftragsservice.model.entity.base.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface Repository<ID, T extends BaseEntity<ID>> {
    Optional<T> findById(ID id);
    List<T> findAll();
    boolean save(T entity);
    T update(T entity);
    T delete(T entity);
}
