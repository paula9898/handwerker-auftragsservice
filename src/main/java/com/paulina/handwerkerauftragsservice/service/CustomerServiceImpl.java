package com.paulina.handwerkerauftragsservice.service;

import com.paulina.handwerkerauftragsservice.exception.CustomerNotFoundException;
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

        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(String id) {
        return customerRepository.findById(id)
                .orElseThrow(() ->
                        new CustomerNotFoundException("Customer with " + id + "was not found"));
    }

    @Override
    public Customer updateCustomer(String id, Customer customer) {
        Customer foundCustomer = customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("Customer with: " + id + "not found")
        );

        foundCustomer.setFirstname(customer.getFirstname());
        foundCustomer.setSurname(customer.getSurname());
        foundCustomer.setPhone(customer.getPhone());
        foundCustomer.setEmail(customer.getEmail());
        foundCustomer.setAddress(customer.getAddress());

        return customerRepository.save(foundCustomer);
    }

    @Override
    public void deleteCustomer(String id) {
        Customer customerToDelete = customerRepository.findById(id) .orElseThrow(() ->
                new CustomerNotFoundException("Customer with " + id + "was not found"));

        customerRepository.delete(customerToDelete);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
