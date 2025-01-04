package com.task.feature.task.service.impl;

import com.task.feature.task.model.Task;
import com.task.feature.task.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TaskImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public Task create(Task task) {
        return this.taskRepository.save(task);
    }

    @Override
    public List<Task> create(List<Task> tasks) {
        return this.taskRepository.saveAll(tasks);
    }

    @Override
    public List<Task> list() {
        return this.taskRepository.findAll();
    }

    @Override
    public Task get(Long id) {
        return this.taskRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Task not found"));
    }

    @Override
    public Task update(Task task) {
        return this.taskRepository.save(task);
    }

    @Override
    public void delete(Task task) {
        this.taskRepository.delete(task);
    }
}
