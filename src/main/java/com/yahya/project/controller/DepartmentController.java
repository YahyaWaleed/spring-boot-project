package com.yahya.project.controller;

import com.yahya.project.dto.DepartmentRequest;
import com.yahya.project.dto.DepartmentResponse;
import com.yahya.project.service.DepartmentService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    // get service object and do dependency injection
    private DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public DepartmentResponse createDepartment(@RequestBody DepartmentRequest departmentRequest){
        return departmentService.createDepartment(departmentRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartmentById(@PathVariable Integer id) {
        departmentService.deleteDepartment(id);
    }

    @GetMapping
    public List<DepartmentResponse> getAllDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("/{id}")
    public DepartmentResponse getDepartmentById(@PathVariable Integer id) {
        return departmentService.getDepartmentById(id);
    }

    @PutMapping("/{id}")
    public DepartmentResponse updateDepartment(@PathVariable Integer id, @RequestBody DepartmentRequest departmentRequest) {
        return departmentService.updateDepartmentById(id, departmentRequest);
    }
}
