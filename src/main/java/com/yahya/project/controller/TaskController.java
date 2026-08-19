package com.yahya.project.controller;

import com.yahya.project.dto.ProjectRequest;
import com.yahya.project.dto.ProjectResponse;
import com.yahya.project.dto.TaskRequest;
import com.yahya.project.dto.TaskResponse;
import com.yahya.project.service.ProjectService;
import com.yahya.project.service.TaskService;
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
    public TaskResponse updateTaskById(@PathVariable Integer id, @RequestBody TaskRequest taskRequest) {
        return taskService.updateTaskById(id, taskRequest);
    }

    @PostMapping
    public TaskResponse createTask(@RequestBody TaskRequest taskRequest) {
        return taskService.createTask(taskRequest);
    }
}
