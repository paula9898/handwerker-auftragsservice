package com.paulina.handwerkerauftragsservice.service;

import com.paulina.handwerkerauftragsservice.exception.EmployeeNotFoundException;
import com.paulina.handwerkerauftragsservice.model.entity.Employee;
import com.paulina.handwerkerauftragsservice.repository.base.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee createEmployee(Employee employee) {
        if(employee.getId() == null) {
            employee.setId(UUID.randomUUID().toString());
        }

        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(
                "Employee with id " + id + " was not found"
        ));
    }

    @Override
    public Employee updateEmployee(String id, Employee employee) {
        Employee foundEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("Employee with: " + id + "not found")
        );

        foundEmployee.setFirstName(employee.getFirstName());
        foundEmployee.setSurname(employee.getSurname());
        foundEmployee.setPhone(employee.getPhone());
        foundEmployee.setEmail(employee.getEmail());
        foundEmployee.setAddress(employee.getAddress());


        return employeeRepository.save(foundEmployee);

    }

    @Override
    public void deleteEmployee(String id) {
        Employee employeeToDelete = employeeRepository.findById(id) .orElseThrow(() ->
                new EmployeeNotFoundException("Employee  with " + id + "was not found"));

        employeeRepository.delete(employeeToDelete);

    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
