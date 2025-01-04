package com.task.feature.livre.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LivreDto {
    private int id;
    private String title;
    private String author;
    private int isbn;
    private Date datePublication;
    private int numberOfPages;
}
