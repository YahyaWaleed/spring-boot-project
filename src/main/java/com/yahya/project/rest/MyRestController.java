package com.yahya.project.rest;

import com.yahya.project.dao.DepartmentDAO;
import com.yahya.project.entity.Department;
import com.yahya.project.service.DepartmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyRestController {

    private DepartmentService departmentService;

    // create department
    @PostMapping("/departments")
    public void createDepartment() {
        departmentService.save();
    };
}
