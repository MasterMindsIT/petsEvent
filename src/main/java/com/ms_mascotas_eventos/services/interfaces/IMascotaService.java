package com.ms_mascotas_eventos.services.interfaces;

import java.util.List;

import com.ms_mascotas_eventos.dtos.request.MascotaRequest;

public interface IMascotaService {
    //definir los crud de la entidad mascota

    //listar mascotas
    public List<MascotaRequest> findAll();

    //buscar por id mascota
    public MascotaRequest findById(Long id);


    //crear mascota
    public MascotaRequest save(MascotaRequest mascota);

    //editar mascota
    public MascotaRequest update(Long id, MascotaRequest mascota);

    //eliminar mascota
    public void delete(Long id);
}
