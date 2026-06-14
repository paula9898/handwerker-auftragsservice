package com.paulina.handwerkerauftragsservice.service;

import com.paulina.handwerkerauftragsservice.model.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer getCustomerById(String id);
    Customer updateCustomer(String id,Customer customer);
    void deleteCustomer(String id);
    List<Customer> getAllCustomers();
}
