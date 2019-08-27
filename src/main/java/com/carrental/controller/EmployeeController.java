package com.carrental.controller;

import com.carrental.domain.model.Department;
import com.carrental.domain.model.Employee;
import com.carrental.service.DepartmentService;
import com.carrental.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    @GetMapping("/create")
    public String createEmployeeForm(Model model) {
        List<Department> departments = departmentService.getAllDepartments();

        model.addAttribute("departments",departments);
        model.addAttribute("employee", new Employee());
        return "employee/form";
    }

    @PostMapping("/create")
    public String createEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.createEmployee(employee);
        log.info("Created new employee {}", employee);

        return "redirect:/employee/list";
    }

    @GetMapping("/list")
    public String rentList(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();

        model.addAttribute("employees", employees);
        return "employee/list";
    }

    @GetMapping("/edit/{id}")
    public String editEmployeeForm(@PathVariable("id") Integer id, Model model) {
        Optional<Employee> maybeEmployee = employeeService.getEmployeeById(id);

        if (maybeEmployee.isPresent()) {
            model.addAttribute("employee", maybeEmployee.get());
            return "employee/edit-form";
        } else {
            return "redirect:/employee/create";
        }
    }

    @PostMapping("/edit/{id}")
    public String editEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.editEmployee(employee);

        return "redirect:/employee/list";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") Integer id) {
        employeeService.deleteById(id);
        return "redirect:/employee/list";
    }
}