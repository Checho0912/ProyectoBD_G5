package com.proyecto.EasyIT.Service;

import com.proyecto.EasyIT.Model.Dispositivo_de_oficina;

import java.util.List;

public interface Dispositivo_de_oficinaService {
    //Listar
    List<Dispositivo_de_oficina> findAll();

    //Guardar
    Dispositivo_de_oficina save(Dispositivo_de_oficina dispositivo);

    // Actualizar
    Dispositivo_de_oficina update(int id, Dispositivo_de_oficina dispositivo);

    //Eliminar
    void delete(int id);

}
