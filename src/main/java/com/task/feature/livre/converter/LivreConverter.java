package com.task.feature.livre.converter;

import com.task.feature.livre.command.CreateLivreCommand;
import com.task.feature.livre.command.UpdateLivreCommand;
import com.task.feature.livre.dtos.LivreDto;
import com.task.feature.livre.model.Livre;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LivreConverter {

    public Livre create(CreateLivreCommand createdLivreCommand) {
        return Livre
                .builder()
                .id(createdLivreCommand.id())
                .titre(createdLivreCommand.titre())
                .auteur(createdLivreCommand.auteur())
                .datePublication(createdLivreCommand.datePublication())
                .build();
    }

    public Livre update(Long id, UpdateLivreCommand updatedLivreCommand) {
        return Livre
                .builder()
                .id(id)
                .titre(updatedLivreCommand.titre())
                .auteur(updatedLivreCommand.auteur())
                .datePublication(updatedLivreCommand.datePublication())
                .build();
    }

    public LivreDto convert(Livre livre) {
        return LivreDto
                .builder()
                .id(Math.toIntExact(livre.getId()))
                .title(livre.getTitre())
                .isbn(livre.getIsbn())
                .author(livre.getAuteur())
                .build();
    }


}
