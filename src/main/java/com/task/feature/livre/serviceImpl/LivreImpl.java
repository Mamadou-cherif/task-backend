package com.task.feature.livre.serviceImpl;

import com.task.feature.livre.model.Livre;
import com.task.feature.livre.repository.LivreRepository;
import com.task.feature.livre.service.LivreService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LivreImpl implements LivreService {
    @Autowired
   private LivreRepository livreRepository;

    @Override
    public Livre create(Livre livre) {
        return this.livreRepository.save(livre);
    }

    @Override
    public List<Livre> create(List<Livre> livres) {
        return this.livreRepository.saveAll(livres);
    }

    @Override
    public List<Livre> list() {
        return this.livreRepository.findAll();
    }

    @Override
    public Livre get(Long id) {
        return this.livreRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Livre not found"));
    }

    @Override
    public Livre update(Livre livre) {
        return this.livreRepository.save(livre);
    }

    @Override
    public void delete(Livre livre) {
        this.livreRepository.delete(livre);
    }
}
