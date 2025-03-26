package com.ms_mascotas_eventos.Errors;

public class RegionNotFoundException extends RuntimeException {

    public RegionNotFoundException() {
        super("Region not found");
    }

    public RegionNotFoundException(String message) {
        super(message);
    }

    public RegionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegionNotFoundException(Throwable cause) {
        super(cause);
    }

    

}
