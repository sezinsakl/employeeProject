package com.example.turkcellProject.service;

import com.example.turkcellProject.model.Employee;
import com.example.turkcellProject.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    EmployeeResponse getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    Employee addEmployee(Employee employee);

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);
}

