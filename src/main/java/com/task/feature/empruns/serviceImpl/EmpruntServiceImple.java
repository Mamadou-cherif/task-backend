package com.task.feature.empruns.serviceImpl;


import com.task.feature.empruns.models.Emprunt;
import com.task.feature.empruns.repository.EmpruntRepository;
import com.task.feature.empruns.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpruntServiceImple implements EmpruntService {
    @Autowired
    private EmpruntRepository empruntRepository;

    @Override
    public Emprunt create(Emprunt emprunt) {
        return this.empruntRepository.save(emprunt);
    }

    @Override
    public List<Emprunt> create(List<Emprunt> emprunts) {
        return this.empruntRepository.saveAll(emprunts);
    }

    @Override
    public List<Emprunt> list() {
        return this.empruntRepository.findAll();
    }

    @Override
    public Emprunt get(Long id) {
        return this.empruntRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Emprunt not found"));
    }

    @Override
    public Emprunt update(Emprunt emprunt) {
        return this.empruntRepository.save(emprunt);
    }

    @Override
    public void delete(Emprunt emprunt) {
        this.empruntRepository.delete(emprunt);
    }
}
