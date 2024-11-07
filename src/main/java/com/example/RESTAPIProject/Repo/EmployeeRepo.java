package com.example.RESTAPIProject.Repo;

import com.example.RESTAPIProject.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
