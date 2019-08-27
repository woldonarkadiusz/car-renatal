package com.carrental.service;

import com.carrental.domain.model.Employee;
import com.carrental.domain.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public void createEmployee (Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Integer id) { return employeeRepository.findById(id); }

    public void editEmployee(Employee employee) { employeeRepository.save(employee); }

    public void deleteById(Integer id) { employeeRepository.deleteById(id); }
}
