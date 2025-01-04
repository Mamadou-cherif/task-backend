package com.task.feature.livre.model;

import com.task.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livre extends BaseEntity {
        private int isbn;
        private String titre;
        private String auteur;
        private Date datePublication;
        private int numberOfPages;
}
