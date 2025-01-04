package com.task.feature.livre.command;

import java.util.Date;

public record CreateLivreCommand(
        Long id,
        int isbn,
        String titre,
        String auteur,
        Date datePublication,
        int numberOfPages)
{}

