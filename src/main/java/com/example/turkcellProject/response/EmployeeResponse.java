package com.example.turkcellProject.response;

import com.example.turkcellProject.model.Department;
import com.example.turkcellProject.model.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponse {
    private Employee employee;
    private Department department;

}

