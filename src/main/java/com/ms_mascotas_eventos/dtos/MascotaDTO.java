package com.ms_mascotas_eventos.dtos;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
@Builder
public record MascotaDTO(
    Long id,
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 255, message = "El nombre no puede tener más de 255 caracteres")
    String nombre,
    @NotNull(message = "El tipo de mascota no puede ser nulo")
    Long tipoMascotaId,
    @NotNull(message = "El participante no puede ser nulo")
    Long participanteId
) implements Serializable {}