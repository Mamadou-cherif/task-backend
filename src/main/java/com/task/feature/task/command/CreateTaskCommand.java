package com.task.feature.task.command;

import com.task.feature.task.model.Statut;

public record CreateTaskCommand(
     int id,
     String libelle,
     String description,
     Statut statut) {
}
