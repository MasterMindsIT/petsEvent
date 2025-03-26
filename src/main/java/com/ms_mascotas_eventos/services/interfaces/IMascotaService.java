package com.ms_mascotas_eventos.services.interfaces;

import java.util.List;

import com.ms_mascotas_eventos.entities.Mascota;

public interface IMascotaService {
    //definir los crud de la entidad mascota

    //listar mascotas
    public List<Mascota> findAll();

    //buscar por id mascota
    public Mascota findById(Long id);


    //crear mascota
    public Mascota save(Mascota mascota);

    //editar mascota
    public Mascota update(Long id, Mascota mascota);

    //eliminar mascota
    public void delete(Long id);
}
