package com.ms_mascotas_eventos.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*; 
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.ms_mascotas_eventos.controllers.RegionController;
import com.ms_mascotas_eventos.dtos.responses.RegionResponse;

@Component
public class RegionModelAssembler  implements RepresentationModelAssembler<RegionResponse , EntityModel<RegionResponse >> {

    /**
     * Este método transforma una Pelicula en un EntityModel con enlaces.
     * Incluye:
     * ✅ self → Ver esta película
     * 🗑 delete → Eliminar la película
     * 🔁 update → Actualizar la película
     * 📋 all → Ver todas las películas
     */
    @Override
    public EntityModel<RegionResponse> toModel(RegionResponse  region) {
        return EntityModel.of(
            region, // Entidad original

                // Enlace al detalle de la película (GET /peliculas/{id})
                linkTo(methodOn(RegionController.class)
                        .findById(region.id()))
                        .withSelfRel(),

                // Enlace para eliminar (DELETE /peliculas/{id})
                linkTo(methodOn(RegionController.class)
                        .delete(region.id()))
                        .withRel("delete"),

                // Enlace para actualizar (PUT /peliculas/{id}) – cuerpo ignorado aquí
                linkTo(methodOn(RegionController.class)
                        .update(region.id(), null))
                        .withRel("update"),

                // Enlace para ver todas las películas (GET /peliculas)
                linkTo(methodOn(RegionController.class)
                        .findAll())
                        .withRel("all"));
    }
}
