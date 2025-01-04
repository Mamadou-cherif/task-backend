package com.task.feature.empruns.controller;

import com.task.core.helpers.ApiResponse;
import com.task.feature.empruns.commands.CreateEmpruntCommand;
import com.task.feature.empruns.converter.EmpruntConverter;
import com.task.feature.empruns.dtos.EmpruntDto;
import com.task.feature.empruns.models.Emprunt;
import com.task.feature.empruns.service.EmpruntService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprunts")
@RequiredArgsConstructor
public class EmpruntController {
    private final EmpruntService empruntService;
    private final EmpruntConverter empruntConverter;


    @PostMapping
    public ApiResponse<EmpruntDto> create(@RequestBody CreateEmpruntCommand createEmpruntCommand){
        return ApiResponse.created(
                this.empruntConverter.convert(this.empruntService.create(this.empruntConverter.create(createEmpruntCommand))),
                "Emprunt crée avec succès"
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<EmpruntDto> getById(@PathVariable Long id) {
        return ApiResponse.success(
                this.empruntConverter.convert(
                        this.empruntService.get(id)
                ),"succes"
        );
    }


    @DeleteMapping("/{id}")
    public ApiResponse deleteById(@PathVariable Long id) {
        Emprunt emprunt = this.empruntService.get(id);

        if(emprunt != null) {
            this.empruntService.delete(emprunt);
        }
        return ApiResponse.success("Suppression Réussie");
    }

    @PutMapping("/{id}")
    public ApiResponse<EmpruntDto> update(@RequestBody CreateEmpruntCommand createEmpruntCommand){
        return ApiResponse.created(
                this.empruntConverter.convert(this.empruntService.update(this.empruntConverter.create(createEmpruntCommand))),
                "Emprunt modifiée avec succès"
        );
    }


    @GetMapping
    public ResponseEntity<List<EmpruntDto>> listEmprunt(){
        List<EmpruntDto> emprunts = this.empruntService.list()
                .stream()
                .map(empruntConverter::convert)
                .toList();
        return new ResponseEntity<>(
                emprunts,
                HttpStatus.OK
        );
    }
}
