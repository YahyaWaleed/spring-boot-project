package com.yahya.project.service;

import com.yahya.project.dao.DepartmentDAO;
import com.yahya.project.entity.Department;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private DepartmentDAO departmentDAO;

    public void save(){
        departmentDAO.save(new Department());
    }
}
