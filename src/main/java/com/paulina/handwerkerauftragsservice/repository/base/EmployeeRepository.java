package com.paulina.handwerkerauftragsservice.repository.base;

import com.paulina.handwerkerauftragsservice.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
