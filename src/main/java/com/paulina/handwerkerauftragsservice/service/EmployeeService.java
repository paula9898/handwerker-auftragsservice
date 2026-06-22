package com.paulina.handwerkerauftragsservice.service;

import com.paulina.handwerkerauftragsservice.model.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee getEmployeeById(String id);
    Employee updateEmployee(String id, Employee employee);
    void deleteEmployee(String id);
    List<Employee> getAllEmployees();
}
