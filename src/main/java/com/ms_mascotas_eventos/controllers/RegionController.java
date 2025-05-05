package com.ms_mascotas_eventos.controllers;

import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms_mascotas_eventos.dtos.request.RegionRequest;
import com.ms_mascotas_eventos.dtos.responses.RegionResponse;
import com.ms_mascotas_eventos.dtos.responses.ResponseWrapperEntity;
import com.ms_mascotas_eventos.dtos.responses.ResponseWrapperList;
import com.ms_mascotas_eventos.dtos.responses.ResponseWrapperMessage;
import com.ms_mascotas_eventos.hateoas.RegionModelAssembler;
import com.ms_mascotas_eventos.services.interfaces.IRegionService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@AllArgsConstructor
@RequestMapping("regiones")
@Slf4j
public class RegionController {

    private final IRegionService regionService;
    private final RegionModelAssembler regionModelAssembler;

    @GetMapping
    public ResponseEntity<?> findAll() {
        log.info("Controller todas las regiones");
        List<RegionResponse> list = regionService.findAll();
        if(list.isEmpty())
                return ResponseEntity.ok(new ResponseWrapperMessage<>("204", 0,  "No se encontraron datos para mostrar"));
        List<EntityModel<RegionResponse>> listModel = list.stream()
                                        .map(regionModelAssembler::toModel)
                                        .toList();
        return ResponseEntity.ok( new ResponseWrapperList<>("Ok", listModel.size(), listModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        log.info("Controller regiones por ID");
        return ResponseEntity.ok(new ResponseWrapperEntity<>("200", 1, regionModelAssembler.toModel( regionService.findById(id))));
    }
    
    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody RegionRequest region) {
        log.info("Controller guardar region");
        return ResponseEntity.ok(new ResponseWrapperEntity<>("201", 1, regionModelAssembler.toModel(  regionService.save(region))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id,@Valid @RequestBody RegionRequest region) {
        log.info("Controller actualizar region por ID");
        return  ResponseEntity.ok(new ResponseWrapperEntity<>("202", 1,regionModelAssembler.toModel( regionService.update(id, region))));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        log.info("Controller eliminar region por ID");
        if(regionService.delete(id))
        return ResponseEntity.ok(new ResponseWrapperMessage<>("204", 1,  "Se elimino la region con ID: "+id));
        return ResponseEntity.ok(new ResponseWrapperMessage<>("204", 0,  "No se puede eliminar la region con ID: "+id+" porque tiene comunas asociadas"));
    }
}
