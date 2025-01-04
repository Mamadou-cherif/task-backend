package com.task.feature.empruns.models;

import com.task.core.entity.BaseEntity;
import com.task.feature.livre.model.Livre;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@SuperBuilder
@Table(name= "emprunts")
public class Emprunt extends BaseEntity {
   private String empruntePar;
   private Date date;
   @OneToOne
   private Livre livre;
}
