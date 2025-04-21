package com.ms_mascotas_eventos.dtos.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.io.Serializable;
import java.time.LocalDateTime;
@Builder
public record EventoRequest(
    Long id,
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 255, message = "El nombre no puede tener más de 255 caracteres")
    String nombre,
    @Size(max = 1000, message = "La descripción no puede tener más de 1000 caracteres")
    String descripcion,
    @NotNull(message = "La fecha de inicio no puede ser nula")
    @FutureOrPresent(message = "La fecha de inicio debe ser en el presente o futuro")
    LocalDateTime fechaInicio,
    @NotNull(message = "La fecha de fin no puede ser nula")
    @FutureOrPresent(message = "La fecha de fin debe ser en el presente o futuro")
    LocalDateTime fechaFin,
    @NotBlank(message = "La ubicación no puede estar vacía")
    @Size(max = 255, message = "La ubicación no puede tener más de 255 caracteres")
    String ubicacion,
    @NotNull(message = "La comuna no puede ser nula")
    Long comunaId
) implements Serializable {}