package com.yahya.project.service;


import com.yahya.project.dto.EmployeeRequest;
import com.yahya.project.dto.EmployeeResponse;
import com.yahya.project.entity.Department;
import com.yahya.project.entity.Employee;
import com.yahya.project.repository.DepartmentRepository;
import com.yahya.project.repository.EmployeeRepository;
import com.yahya.project.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    // method to convert a Employee entity to a DTO(Employee Response) entity
    private EmployeeResponse toEmployeeResponse(Employee employee) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(employee.getId());
        employeeResponse.setName(employee.getName());
        employeeResponse.setEmail(employee.getEmail());
        employeeResponse.setRole(employee.getRole());
        employeeResponse.setDepartmentId(employee.getDepartment().getId());
        employeeResponse.setDepartmentName(employee.getDepartment().getName());

        return employeeResponse;
    }

    // create new employee
    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
       Department department = departmentRepository.findById(employeeRequest.getDepartmentId()).orElseThrow(() -> new EntityNotFoundException("Department with this ID is not found"));

       Employee employee = new Employee();
       employee.setName(employeeRequest.getName());
       employee.setRole(employeeRequest.getRole());
       employee.setEmail(employeeRequest.getEmail());
       employee.setDepartment(department);

       employeeRepository.save(employee);

       return toEmployeeResponse(employee);
    }

    // get one employee
    public EmployeeResponse getEmployeeById(Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee with this ID is not found"));
        return toEmployeeResponse(employee);
    }

    // get all employees
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.findAll().stream().map(this::toEmployeeResponse).toList();
    }

    // update one employee
    public EmployeeResponse updateEmployeeById(Integer id, EmployeeRequest employeeRequest) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee with this ID is not found"));
        Department department = departmentRepository.findById(employeeRequest.getDepartmentId()).orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + employeeRequest.getDepartmentId()));

        employee.setDepartment(department);
        employee.setEmail(employeeRequest.getEmail());
        employee.setName(employeeRequest.getName());
        employee.setRole(employeeRequest.getRole());


        employeeRepository.save(employee);
        return toEmployeeResponse(employee);
    }

    // delete an employee
    public void deleteEmployeeById(Integer id) {
        if (!employeeRepository.existsById(id)) {
            throw new EntityNotFoundException("Employee not found");
        }
        employeeRepository.deleteById(id);
    }
}
