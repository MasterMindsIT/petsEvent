package com.ms_mascotas_eventos.services.interfaces;

import java.util.List;

import com.ms_mascotas_eventos.dtos.MascotaDTO;
import com.ms_mascotas_eventos.entities.Mascota;

public interface IMascotaService {
    //definir los crud de la entidad mascota

    //listar mascotas
    public List<MascotaDTO> findAll();

    //buscar por id mascota
    public MascotaDTO findById(Long id);


    //crear mascota
    public MascotaDTO save(MascotaDTO mascota);

    //editar mascota
    public MascotaDTO update(Long id, MascotaDTO mascota);

    //eliminar mascota
    public void delete(Long id);
}
