package com.task.feature.task.dtos;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.task.feature.task.model.Statut;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskDto {
    private int id;
    private String libelle;
    private String description;
    private Statut statut;
}
