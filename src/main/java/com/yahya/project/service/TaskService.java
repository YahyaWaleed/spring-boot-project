package com.yahya.project.service;

import com.yahya.project.dto.*;
import com.yahya.project.entity.Employee;
import com.yahya.project.entity.Project;
import com.yahya.project.entity.Task;
import com.yahya.project.repository.EmployeeRepository;
import com.yahya.project.repository.ProjectRepository;
import com.yahya.project.repository.TaskRepository;
import com.yahya.project.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final EmployeeRepository employeeRepository;
    public TaskService(ProjectRepository projectRepository, TaskRepository taskRepository, EmployeeRepository employeeRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
        this.employeeRepository = employeeRepository;
    }

    // method to convert a Project entity to a DTO(Project Response) entity
    private TaskResponse toTaskResponse(Task task) {
        List<EmployeeSummary> employeeSummaries = task.getEmployees().stream()
                .map(emp -> {
                    EmployeeSummary summary = new EmployeeSummary();
                    summary.setId(emp.getId());
                    summary.setName(emp.getName());
                    return summary;
                })
                .toList();


        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setId(task.getId());
        taskResponse.setTitle(task.getTitle());
        taskResponse.setDescription(task.getDescription());
        taskResponse.setDueDate(task.getDueDate());
        taskResponse.setPriority(task.getPriority());
        taskResponse.setStatus(task.getStatus());
        taskResponse.setProjectId(task.getProject().getId());
        taskResponse.setProjectName(task.getProject().getName());
        taskResponse.setAssignedEmployees(employeeSummaries);

        return taskResponse;
    }

    // create new task
    public TaskResponse createTask(TaskRequest taskRequest) {

        Project project = projectRepository.findById(taskRequest.getProjectId()).orElseThrow(() -> new EntityNotFoundException("Task with this ID is not found"));
        Task task = new Task();

        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setDueDate(taskRequest.getDueDate());
        task.setPriority(taskRequest.getPriority());
        task.setStatus(taskRequest.getStatus());
        task.setProject(project);

        taskRepository.save(task);

        return toTaskResponse(task);
    }

    // get all tasks
    public List<TaskResponse> getAllTasks() {
        return (taskRepository.findAll().stream().map(this::toTaskResponse).toList());
    }

    // get one task
    public TaskResponse getTaskById(Integer id) {
        return toTaskResponse(taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Task with this ID is not found")));
    }

    // delete a task
    public void deleteTaskById(Integer id) {
        if (!taskRepository.existsById(id)) {
            throw new EntityNotFoundException("not found");
        }
        taskRepository.deleteById(id);
    }

    // update a project
    public TaskResponse updateTaskById(Integer id, TaskRequest taskRequest) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Task with this ID is not found"));
        Project project = projectRepository.findById(taskRequest.getProjectId()).orElseThrow(() -> new EntityNotFoundException("Task with this ID is not found"));


        task.setProject(project);
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setDueDate(taskRequest.getDueDate());
        task.setStatus(taskRequest.getStatus());
        task.setPriority(taskRequest.getPriority());


        taskRepository.save(task);

        return toTaskResponse(task);
    }

}


