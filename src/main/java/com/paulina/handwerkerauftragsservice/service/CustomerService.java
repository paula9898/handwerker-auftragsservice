package com.paulina.handwerkerauftragsservice.service;

import com.paulina.handwerkerauftragsservice.model.entity.Address;
import com.paulina.handwerkerauftragsservice.model.entity.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer getCustomerById(UUID id);
    Customer updateCustomer(Customer customer);
    List<Customer> getAllCustomers();
}
