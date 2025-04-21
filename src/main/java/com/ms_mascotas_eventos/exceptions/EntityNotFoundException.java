package com.ms_mascotas_eventos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
    
    public EntityNotFoundException(Class<?> laclass, Long id) {
        super(laclass.getSimpleName() + " con ID " + id + " no fue encontrado.");
    }

}
