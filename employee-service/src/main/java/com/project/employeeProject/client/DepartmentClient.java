package com.project.employeeProject.client;

import com.project.employeeProject.model.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "department-service", url = "http://localhost:8081")
public interface DepartmentClient {

    @GetMapping("/departments/{id}")
    Department getDepartmentById(@PathVariable("id") Long id);
}
