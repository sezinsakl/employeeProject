package com.example.turkcellProject.service;

import com.example.turkcellProject.constant.ErrorMessage;
import com.example.turkcellProject.model.Department;
import com.example.turkcellProject.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public Department addDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException(ErrorMessage.DEPARTMENT_NULL);
        }
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Long id, Department departmentDetails) {
        Department department = departmentRepository.findById(id).orElse(null);
        if (department != null) {
            department.setName(departmentDetails.getName());
            department.setLocation(departmentDetails.getLocation());
            return departmentRepository.save(department);
        }
        return department;
    }

    @Override
    public void deleteDepartment(Long id) {
        if (!departmentRepository.existsById(id)) {
            throw new NoSuchElementException(ErrorMessage.DEPARTMENT_NOT_FOUND + id);
        }
        departmentRepository.deleteById(id);
    }
}
