package com.project.employeeProject.controller;

import com.project.employeeProject.model.Department;
import com.project.employeeProject.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentServiceImpl;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentServiceImpl.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentServiceImpl.getDepartmentById(id);
    }

    @PostMapping
    public Department addDepartment(@RequestBody Department department) {
        return departmentServiceImpl.addDepartment(department);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        return departmentServiceImpl.updateDepartment(id, department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentServiceImpl.deleteDepartment(id);
    }
}
