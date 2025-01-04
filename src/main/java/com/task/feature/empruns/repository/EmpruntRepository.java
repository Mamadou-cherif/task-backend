package com.task.feature.empruns.repository;

import com.task.feature.empruns.models.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {
}
