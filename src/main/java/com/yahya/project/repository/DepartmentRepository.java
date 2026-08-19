package com.yahya.project.repository;

import com.yahya.project.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    // this does all CRUD for me

}
