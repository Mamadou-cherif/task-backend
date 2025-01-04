package com.task.feature.empruns.commands;

import com.task.feature.livre.model.Livre;

import java.util.Date;

public record UpdateEmpruntCommand(
        Livre livre,
        Date date,
        String empruntePar
) {
}
