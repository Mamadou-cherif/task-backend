package com.task.core.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@SuperBuilder
@Setter
@Getter
@NoArgsConstructor
public abstract class BaseEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;
}
