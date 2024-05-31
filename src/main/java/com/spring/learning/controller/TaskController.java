package com.spring.learning.controller;

import com.spring.learning.model.Task;
import com.spring.learning.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{taskId}")
    public Task getTaskById(@PathVariable String taskId) {
        return taskService.getTaskById(taskId);
    }

    @GetMapping("/assignee/{assignee}")
    public List<Task> getTaskByAssignee(@PathVariable String assignee) {
        return taskService.getTaskByAssignee(assignee);
    }

    @GetMapping("/severity/{severity}")
    public List<Task> getTaskBySeverity(@PathVariable int severity) {
        return taskService.getTaskBySeverity(severity);
    }

    @DeleteMapping("/{taskId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteTaskById(@PathVariable String taskId) {
      return taskService.removeTask(taskId);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Task modifyTask(@RequestBody Task task) {
       return taskService.updateTask(task);
    }
}
