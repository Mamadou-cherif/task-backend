package com.task.feature.empruns.commands;

import com.task.feature.livre.model.Livre;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


public record CreateEmpruntCommand(
        Long livreId,
        Date date,
        String empruntePar
) {
}
