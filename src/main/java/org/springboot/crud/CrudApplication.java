package org.springboot.crud;

import org.springboot.crud.model.Employee;
import org.springboot.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication   {

    public static void main(String[] args) {

        SpringApplication.run(CrudApplication.class, args);
    }

}
