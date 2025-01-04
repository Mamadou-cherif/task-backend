package com.task.feature.livre.repository;

import com.task.feature.livre.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LivreRepository extends JpaRepository<Livre,Long> {
   // List<Livre> findByTitle(String title);
}
