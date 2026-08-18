package com.yahya.project.dao;

import com.yahya.project.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDAO extends JpaRepository<Department,Integer> {
    // this does all CRUD for me

}
