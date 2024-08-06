package org.springboot.crud.repository;

import org.springboot.crud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Crud Operation Method

}
