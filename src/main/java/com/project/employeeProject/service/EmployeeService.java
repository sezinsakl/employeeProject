package com.project.employeeProject.service;

import com.project.employeeProject.model.Employee;
import com.project.employeeProject.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    EmployeeResponse getEmployeeById(Long id) throws Exception;

    List<Employee> getAllEmployees();

    Employee addEmployee(Employee employee);

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);
}

