package com.task.feature.empruns.service;

import com.task.feature.empruns.models.Emprunt;
import com.task.feature.livre.model.Livre;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmpruntService {
    Emprunt create(Emprunt emprunt);
    List<Emprunt> create(List<Emprunt> emprunt);
    List<Emprunt> list();
    Emprunt get(Long id);
    Emprunt update(Emprunt emprunt);
    void delete(Emprunt emprunt);
}
