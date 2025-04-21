package com.ms_mascotas_eventos.dtos.responses;

import java.io.Serializable;

public record ComunaResponse( 
    Long id,
    String nombre,
    String regionNombre // a partir del id de la region se puede obtener el nombre de la region
) implements Serializable {}