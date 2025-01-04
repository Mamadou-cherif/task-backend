package com.task.feature.empruns.converter;

import com.task.feature.empruns.commands.CreateEmpruntCommand;
import com.task.feature.empruns.commands.UpdateEmpruntCommand;
import com.task.feature.empruns.dtos.EmpruntDto;
import com.task.feature.empruns.models.Emprunt;
import com.task.feature.livre.model.Livre;
import com.task.feature.livre.repository.LivreRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmpruntConverter {
    LivreRepository livreRepository;

    public Emprunt create(CreateEmpruntCommand createEmpruntCommand) {
        // Récupérer l'objet Livre à partir de l'ID
        Livre livre = livreRepository.findById(createEmpruntCommand.livreId())
                .orElseThrow(() -> new RuntimeException("Livre introuvable avec l'ID : " + createEmpruntCommand.livreId()));

        // Créer l'Emprunt avec le livre récupéré
        return Emprunt.builder()
                .livre(livre)  // Utilisation de l'objet Livre récupéré
                .date(createEmpruntCommand.date())
                .empruntePar(createEmpruntCommand.empruntePar())
                .build();
    }


    public Emprunt update(Long emprunt_id,CreateEmpruntCommand createEmpruntCommand){
        // Récupérer l'objet Livre à partir de l'ID
        Livre livre = livreRepository.findById(createEmpruntCommand.livreId())
                .orElseThrow(() -> new RuntimeException("Livre introuvable avec l'ID : " + createEmpruntCommand.livreId()));

        // Créer l'Emprunt avec le livre récupéré
        return Emprunt.builder()
                .id(emprunt_id)
                .livre(livre)  // Utilisation de l'objet Livre récupéré
                .date(createEmpruntCommand.date())
                .empruntePar(createEmpruntCommand.empruntePar())
                .build();
    }

    public EmpruntDto convert(Emprunt emprunt){
        return EmpruntDto
                .builder()
                .id(emprunt.getId())
                .auteur(emprunt.getLivre().getAuteur())
                .title(emprunt.getLivre().getTitre())
                .date(emprunt.getDate())
                .build();
    }
}
