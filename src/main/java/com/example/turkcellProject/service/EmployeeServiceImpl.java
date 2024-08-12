package com.example.turkcellProject.service;

import com.example.turkcellProject.client.DepartmentClient;
import com.example.turkcellProject.constant.ErrorMessage;
import com.example.turkcellProject.model.Department;
import com.example.turkcellProject.model.Employee;
import com.example.turkcellProject.repository.EmployeeRepository;
import com.example.turkcellProject.response.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentClient departmentClient;

    @Override
    public EmployeeResponse getEmployeeById(Long id) {
        EmployeeResponse response = new EmployeeResponse();
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException(ErrorMessage.EMPLOYEE_NOT_FOUND + id));
        response.setEmployee(employee);
        Department department = departmentClient.getDepartmentById(employee.getDepartmentId());
        if(department == null){
            throw new NoSuchElementException(ErrorMessage.DEPARTMENT_NOT_FOUND + id);
        }else{
            response.setDepartment(department);
        }
        return response;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException(ErrorMessage.EMPLOYEE_NULL);
        }

        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        if (!employeeRepository.existsById(id)) {
            throw new NoSuchElementException(ErrorMessage.EMPLOYEE_NOT_FOUND + id);
        }
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setName(employeeDetails.getName());
            employee.setPosition(employeeDetails.getPosition());
            employee.setSalary(employeeDetails.getSalary());
            return employeeRepository.save(employee);
        }
        return employeeDetails;
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new NoSuchElementException(ErrorMessage.EMPLOYEE_NOT_FOUND + id);
        }
        employeeRepository.deleteById(id);
    }
}


