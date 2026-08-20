package com.yahya.project.service;

import com.yahya.project.dto.EmployeeResponse;
import com.yahya.project.dto.ProjectRequest;
import com.yahya.project.dto.ProjectResponse;
import com.yahya.project.entity.Employee;
import com.yahya.project.entity.Project;
import com.yahya.project.repository.DepartmentRepository;
import com.yahya.project.repository.EmployeeRepository;
import com.yahya.project.repository.ProjectRepository;
import com.yahya.project.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;
    public ProjectService(EmployeeRepository employeeRepository, ProjectRepository projectRepository) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    // method to convert a Project entity to a DTO(Project Response) entity
    private ProjectResponse toProjectResponse(Project project) {
        ProjectResponse projectResponse = new ProjectResponse();
        projectResponse.setId(project.getId());
        projectResponse.setName(project.getName());
        projectResponse.setDescription(project.getDescription());
        projectResponse.setStartDate(project.getStartDate());
        projectResponse.setEndDate(project.getEndDate());
        projectResponse.setManagerId(project.getManager().getId());
        projectResponse.setManagerName(project.getManager().getName());

        return projectResponse;
    }

    // create new project
    public ProjectResponse createProject(ProjectRequest projectRequest) {
        Employee manager = employeeRepository.findById(projectRequest.getManagerId()).orElseThrow(() -> new EntityNotFoundException("Manager with this ID is not found"));
        Project project = new Project();

        project.setName(projectRequest.getName());
        project.setDescription(projectRequest.getDescription());
        project.setStartDate(projectRequest.getStartDate());
        project.setEndDate(projectRequest.getEndDate());
        project.setManager(manager);

        projectRepository.save(project);

        return toProjectResponse(project);
    }

    // get all projects
    public List<ProjectResponse> getAllProjects() {
        return (projectRepository.findAll().stream().map(this::toProjectResponse).toList());
    }

    // get one project
    public ProjectResponse getProjectById(Integer id) {
        return toProjectResponse(projectRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Project with this ID is not found")));
    }

    // delete a project
    public void deleteProjectById(Integer id) {
        if (!projectRepository.existsById(id)) {
            throw new EntityNotFoundException("not found");
        }
        projectRepository.deleteById(id);
    }

    // update a project
    public ProjectResponse updateProjectById(Integer id, ProjectRequest projectRequest) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Project with this ID is not found"));
        Employee manager = employeeRepository.findById(projectRequest.getManagerId()).orElseThrow(() -> new EntityNotFoundException("Manager with this ID is not found"));


        project.setManager(manager);
        project.setName(projectRequest.getName());
        project.setDescription(projectRequest.getDescription());
        project.setStartDate(projectRequest.getStartDate());
        project.setEndDate(projectRequest.getEndDate());

        projectRepository.save(project);

        return toProjectResponse(project);
    }
}
