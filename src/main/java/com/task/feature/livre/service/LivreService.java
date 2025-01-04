package com.task.feature.livre.service;

import com.task.feature.livre.model.Livre;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LivreService {
    Livre create(Livre Livre);
    List<Livre> create(List<Livre> Livres);
    List<Livre> list();
    Livre get(Long id);
    Livre update(Livre Livre);
    void delete(Livre Livre);
}
