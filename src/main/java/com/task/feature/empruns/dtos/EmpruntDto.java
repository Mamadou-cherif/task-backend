package com.task.feature.empruns.dtos;

import com.task.feature.livre.model.Livre;
import lombok.Builder;

import java.util.Date;

@Builder
public class EmpruntDto {
    private Long id;
    private Long livreId;
    private String title;
    private String auteur;
    public Date date;
}
