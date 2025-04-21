package com.ms_mascotas_eventos.dtos.responses;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonPropertyOrder({ "status", "cantidad", "timestamp",  "mensaje"})
public class ResponseWrapperMessage <T>{
    private String status;
    private int cantidad;
    private LocalDateTime timestamp;
    private String mensaje;
    public ResponseWrapperMessage(String status, int cantidad, String mensaje) {
        this.status = status;
        this.cantidad = cantidad;
        this.timestamp = LocalDateTime.now();
        this.mensaje = mensaje;
    }

}
