package com.spring.learning.service;

import com.spring.learning.model.Task;
import com.spring.learning.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task addTask(Task task) {
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return taskRepository.save(task);
    }

    public String removeTask(String taskId) {
        taskRepository.deleteById(taskId);
        return "Task " + taskId + " deleted successfully";
    }

    public Task updateTask(Task task) {
        Task existingTask = taskRepository.findById(task.getTaskId()).get();
        existingTask.setDiscription(task.getDiscription());
        existingTask.setSeverity(task.getSeverity());
        existingTask.setAssignee(task.getAssignee());
        existingTask.setStoryPoint(task.getStoryPoint());
        return taskRepository.save(existingTask);
    }

    public Task getTaskById(String taskId) {
        return taskRepository.findById(taskId).get();
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTaskByAssignee(String assignee) {
        return taskRepository.findByAssignee(assignee);
    }

    public List<Task> getTaskBySeverity(int severity) {
        return taskRepository.findBySeverity(severity);
    }

}
