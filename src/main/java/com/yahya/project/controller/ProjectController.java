package com.yahya.project.controller;

import com.yahya.project.dto.EmployeeRequest;
import com.yahya.project.dto.EmployeeResponse;
import com.yahya.project.dto.ProjectRequest;
import com.yahya.project.dto.ProjectResponse;
import com.yahya.project.service.EmployeeService;
import com.yahya.project.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    // get service object and do dependency injection
    private ProjectService projectService;
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @GetMapping
    public List<ProjectResponse> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ProjectResponse getProjectById(@PathVariable Integer id) {
        return projectService.getProjectById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable Integer id) {
        projectService.deleteProjectById(id);
    }

    @PutMapping("/{id}")
    public ProjectResponse updateProjectById(@PathVariable Integer id, @Valid @RequestBody ProjectRequest projectRequest) {
        return projectService.updateProjectById(id, projectRequest);
    }

    @PostMapping
    public ProjectResponse createEmployee(@Valid @RequestBody ProjectRequest projectRequest) {
        return projectService.createProject(projectRequest);
    }

}
