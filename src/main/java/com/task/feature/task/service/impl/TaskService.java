package com.task.feature.task.service.impl;

import com.task.feature.task.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    Task create(Task Task);
    List<Task> create(List<Task> Tasks);
    List<Task> list();
    Task get(Long id);
    Task update(Task Task);
    void delete(Task Task);
}
