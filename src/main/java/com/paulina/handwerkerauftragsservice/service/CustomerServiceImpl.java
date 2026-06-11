package com.paulina.handwerkerauftragsservice.service;

import com.paulina.handwerkerauftragsservice.exception.DuplicateEmailException;
import com.paulina.handwerkerauftragsservice.model.entity.Customer;
import com.paulina.handwerkerauftragsservice.repository.base.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service

public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Customer createCustomer(Customer customer) {

        if(customer.getId() == null) {
            customer.setId(UUID.randomUUID().toString());
        }
        customer.setFirstname(customer.getFirstname());
        customer.setSurname(customer.getSurname());
        customer.setEmail(customer.getEmail());
        customer.setAddress(customer.getAddress());

        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(UUID id) {
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
