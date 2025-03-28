package com.ms_mascotas_eventos.Errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RegionNotFoundException extends RuntimeException {

    public RegionNotFoundException(long id) {
        super("Region "+ id +"not found");
    }
   

}
