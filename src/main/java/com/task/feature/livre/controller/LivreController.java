package com.task.feature.livre.controller;

import com.task.core.helpers.ApiResponse;
import com.task.feature.livre.command.CreateLivreCommand;
import com.task.feature.livre.command.UpdateLivreCommand;
import com.task.feature.livre.converter.LivreConverter;
import com.task.feature.livre.dtos.LivreDto;
import com.task.feature.livre.model.Livre;
import com.task.feature.livre.service.LivreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livre")
@RequiredArgsConstructor
public class LivreController {
    private final LivreService livreService;
    private final LivreConverter livreConverter;


    @PostMapping
    public ApiResponse<LivreDto> create(@RequestBody CreateLivreCommand createLivreCommand){
        return ApiResponse.created(
                this.livreConverter.convert(this.livreService.create(this.livreConverter.create(createLivreCommand))),
                "Livre crée avec succès"
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<LivreDto> getById(@PathVariable Long id) {
        return ApiResponse.success(
                this.livreConverter.convert(
                        this.livreService.get(id)
                ),"succes"
        );
    }


    @DeleteMapping("/{id}")
    public ApiResponse deleteById(@PathVariable Long id) {
        Livre livre = this.livreService.get(id);

        if(livre != null) {
            this.livreService.delete(livre);
        }
        return ApiResponse.success("Suppression Réussie");
    }

    @PutMapping("/{id}")
    public ApiResponse<LivreDto> update(@PathVariable Long id, @RequestBody UpdateLivreCommand updateLivreCommand) {
        // Assurez-vous que le livre existe
        this.livreService.get(id);

        // Effectuez la mise à jour et la conversion
        LivreDto updatedLivre = this.livreConverter.convert(
                this.livreService.update(
                        this.livreConverter.update(id, updateLivreCommand)
                )
        );

        // Retournez une réponse avec un message de succès
        return ApiResponse.success(
                updatedLivre,
                String.format("Livre avec ID %s est mis à jour avec succès", id)
        );
    }


//    @PutMapping("/{id}")
//    public ApiResponse<ContactDto> update(@PathVariable Long id, @RequestBody UpdateContactCommand updateOrganizationCommand){
//        this.contactService.get(id);
//        return ApiResponse.success(
//                this.contactConverter.convert(this.contactService.update(this.contactConverter.update(id, updateOrganizationCommand))),
//                String.format("Contact de ID est mis a jour avec succès: %s", id)
//        );
//    }

    @GetMapping
    public ResponseEntity<List<LivreDto>> listLivre(){
        List<LivreDto> livres = this.livreService.list()
                .stream()
                .map(livreConverter::convert)
                .toList();
        return new ResponseEntity<>(
                livres,
                HttpStatus.OK
        );
    }

}
