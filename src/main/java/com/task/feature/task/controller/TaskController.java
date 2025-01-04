package com.task.feature.task.controller;

import com.task.core.helpers.ApiResponse;
import com.task.feature.task.command.CreateTaskCommand;
import com.task.feature.task.converter.TaskConverter;
import com.task.feature.task.dtos.CustumResponse;
import com.task.feature.task.dtos.TaskDto;
import com.task.feature.task.model.Task;
import com.task.feature.task.service.impl.TaskService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final TaskConverter taskConverter;


    @PostMapping
    public ApiResponse<TaskDto> create(@RequestBody CreateTaskCommand createTaskCommand){
        return ApiResponse.created(
                this.taskConverter.convert(this.taskService.create(this.taskConverter.create(createTaskCommand))),
                "Task crée avec succès"
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<TaskDto> getById(@PathVariable Long id) {
        return ApiResponse.success(
                this.taskConverter.convert(
                        this.taskService.get(id)
                ),"succes"
        );
    }


    @DeleteMapping("/{id}")
    public ApiResponse deleteById(@PathVariable Long id) {
        Task task = this.taskService.get(id);

        if(task != null) {
            this.taskService.delete(task);
        }
        return ApiResponse.success("Suppression Réussie");
    }

    @PutMapping("/{id}")
    public ApiResponse<TaskDto> update(@RequestBody CreateTaskCommand createTaskCommand){
        return ApiResponse.created(
                this.taskConverter.convert(this.taskService.update(this.taskConverter.create(createTaskCommand))),
                "Task modifiée avec succès"
        );
    }


    @GetMapping
    public ResponseEntity<List<TaskDto>> listTask(){
        List<TaskDto> tasks = this.taskService.list()
                .stream()
                .map(taskConverter::convert)
                .toList();
        return new ResponseEntity<>(
                tasks,
                HttpStatus.OK
        );
    }

}
