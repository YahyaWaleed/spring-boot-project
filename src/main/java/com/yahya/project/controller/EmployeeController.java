package com.yahya.project.controller;

import com.yahya.project.dto.EmployeeRequest;
import com.yahya.project.dto.EmployeeResponse;
import com.yahya.project.service.DepartmentService;
import com.yahya.project.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    // get service object and do dependency injection
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public List<EmployeeResponse> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/{id}")
    public EmployeeResponse updateEmployeeById(@PathVariable Integer id,  @RequestBody EmployeeRequest employeeRequest) {
        return employeeService.updateEmployeeById(id, employeeRequest);
    }

    @PostMapping
    public EmployeeResponse createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return employeeService.createEmployee(employeeRequest);
    }
}
