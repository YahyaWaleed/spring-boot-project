package com.yahya.project.service;

import com.yahya.project.dto.DepartmentRequest;
import com.yahya.project.dto.DepartmentResponse;
import com.yahya.project.entity.Department;
import com.yahya.project.repository.DepartmentRepository;
import com.yahya.project.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    // to access the DepartmentRepository and its CRUD methods
    private final DepartmentRepository departmentRepository;

    // constructor
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    // method to convert a Department entity to a DTO(Department Response) entity
    private DepartmentResponse toDepartmentResponse(Department department) {
        DepartmentResponse departmentResponse = new DepartmentResponse();
        departmentResponse.setId(department.getId());
        departmentResponse.setName(department.getName());
        return departmentResponse;
    }

    // create department (post)
    public DepartmentResponse createDepartment(DepartmentRequest departmentRequest) {
        // create new department
        Department newDepartment = new Department(departmentRequest.getName());
        // save new department
        Department savedDepartment = departmentRepository.save(newDepartment);
        return toDepartmentResponse(savedDepartment);
    }

    // delete department (delete)
    public void deleteDepartment(Integer id){
        if (!departmentRepository.existsById(id)) {
            throw new EntityNotFoundException("Department not found with id: " + id);
        }
         departmentRepository.deleteById(id);
    }

    // get list of departments (get)
    public List<DepartmentResponse> getDepartments() {
        return departmentRepository.findAll().stream().map(this::toDepartmentResponse).toList();
    }

    // get one department
    public DepartmentResponse getDepartmentById(Integer id) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + id));
        return toDepartmentResponse(department);
    }

    // update a department (put)
    public DepartmentResponse updateDepartmentById(Integer id, DepartmentRequest departmentRequest) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + id));
        department.setName(departmentRequest.getName());
        departmentRepository.save(department);
        return toDepartmentResponse(department);
    }
}
