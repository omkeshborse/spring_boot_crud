package org.springboot.crud.controller;


import org.springboot.crud.exception.ResourceNotFoundException;
import org.springboot.crud.model.Employee;
import org.springboot.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

//    Get All employees
    @GetMapping()
    public List<Employee> findAll() {
        return  employeeRepository.findAll()    ;
    }


    // Create employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {

        return  employeeRepository.save(employee);
    }
    // get employee by id
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeByID(@PathVariable long id) {
    Employee employee = employeeRepository.findById(id).orElseThrow(()->
            new ResourceNotFoundException("Employee with id " + id + " not found")); ;
    return ResponseEntity.ok(employee);
    }

//    update employee api
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails) {
        Employee updateEmployee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee with id " + id + " not found") ) ;
        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmail(employeeDetails.getEmail());

        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }
// delete employee
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee with id " + id + " not found")); ;
        employeeRepository.delete(employee);

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
