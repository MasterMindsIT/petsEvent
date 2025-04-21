package com.ms_mascotas_eventos.Errors;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice 
public class GlobalExeptionHandler {

    @ExceptionHandler(RegionNotFoundException.class)
    public ResponseEntity<Object> handlerRegionNotFoundException(RegionNotFoundException e){
        Map<String, Object> body = new HashMap<>();
        body.put("Error", "Not Found");
        body.put("Status", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e){
        return new ResponseEntity<>("Error en el requerimiento", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recurso no encontrado: " + ex.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entidad no encontrada: " + ex.getMessage());
    }

}
