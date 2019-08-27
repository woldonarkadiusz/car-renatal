package com.carrental.service;

import com.carrental.domain.model.Department;
import com.carrental.domain.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public void createDepartment(Department department){
        departmentRepository.save(department);
    }

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(Integer id){
        return departmentRepository.findById(id);
    }

    public void editDepartment (Department department){
        departmentRepository.save(department);
    }

    public void deleteById (Integer id){
        departmentRepository.deleteById(id);
    }

}
