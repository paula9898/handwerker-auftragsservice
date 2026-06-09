package com.paulina.handwerkerauftragsservice.controller;
import com.paulina.handwerkerauftragsservice.model.entity.Customer;
import com.paulina.handwerkerauftragsservice.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;

    }

    @GetMapping("")
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }
}
