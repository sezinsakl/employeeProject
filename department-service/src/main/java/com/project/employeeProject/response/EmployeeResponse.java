package com.project.employeeProject.response;

import com.project.employeeProject.model.Department;
import com.project.employeeProject.model.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponse {
    private Employee employee;
    private Department department;

}

