package com.paulina.handwerkerauftragsservice.repository.base;

import com.paulina.handwerkerauftragsservice.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
