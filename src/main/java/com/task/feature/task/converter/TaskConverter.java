package com.task.feature.task.converter;

import com.task.feature.task.command.CreateTaskCommand;
import com.task.feature.task.dtos.TaskDto;
import com.task.feature.task.model.Task;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TaskConverter {

    public Task create(CreateTaskCommand createdTaskCommand) {
        return Task
                .builder()
                .label(createdTaskCommand.libelle())
                .description(createdTaskCommand.description())
                .build();
    }

    public TaskDto convert(Task task) {
        return TaskDto
                .builder()
                .id(Math.toIntExact(task.getId()))
                .libelle(task.getLabel())
                .description(task.getDescription())
                .build();
    }
}
