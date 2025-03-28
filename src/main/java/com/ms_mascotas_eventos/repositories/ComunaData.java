package com.ms_mascotas_eventos.repositories;

import java.util.ArrayList;
import java.util.List;

import com.ms_mascotas_eventos.entities.Comuna;

public class ComunaData {
    List<Comuna> comunas = new ArrayList<>();

    //Llenado de datos
    public ComunaData(){
        comunas.add(new Comuna(1L,"Santiago", 1L));
        comunas.add(new Comuna(2L,"Providencia", 2L));
        comunas.add(new Comuna(3L,"San Bernardo", 3L));
        comunas.add(new Comuna(4L,"Pudahuel", 1L));
    }

    //Obtener todas las comunas
    public List<Comuna> getAll() {
        return comunas;
    }
    //Obtener comuna por Id
    public Comuna getById(int id) {
        for (Comuna comuna : comunas) {
            if (comuna.getId() == id) {
                return comuna;
            }
        }
        return null;
    }
}
