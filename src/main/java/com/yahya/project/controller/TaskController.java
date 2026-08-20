package com.yahya.project.controller;

import com.yahya.project.dto.*;
import com.yahya.project.service.ProjectService;
import com.yahya.project.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    // get service object and do dependency injection
    private TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping
    public List<TaskResponse> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskResponse getTaskById(@PathVariable Integer id) {
        return taskService.getTaskById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTaskById(@PathVariable Integer id) {
        taskService.deleteTaskById(id);
    }

    @PutMapping("/{id}")
    public TaskResponse updateTaskById(@PathVariable Integer id, @Valid @RequestBody TaskRequest taskRequest) {
        return taskService.updateTaskById(id, taskRequest);
    }

    @PostMapping
    public TaskResponse createTask(@Valid  @RequestBody TaskRequest taskRequest) {
        return taskService.createTask(taskRequest);
    }

    @PutMapping("/{id}/assign")
    public TaskResponse assignEmployees(@PathVariable Integer id, @Valid @RequestBody AssignEmployeeRequest assignEmployeeRequest) {
        return taskService.assignEmployees(id, assignEmployeeRequest);
    }

    // to update only the status of a task
    @PatchMapping("/{id}/status")
    public TaskResponse updateTaskStatus(@PathVariable Integer id, @Valid @RequestBody TaskStatusRequest taskStatusRequest) {
        return taskService.updateTaskStatus(id, taskStatusRequest);
    }


}
