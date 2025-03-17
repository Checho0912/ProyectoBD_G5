package com.proyecto.EasyIT.Service;

import com.proyecto.EasyIT.Model.Administrador;
import com.proyecto.EasyIT.Model.Dispositivo_de_computacion;

import java.util.List;


public interface Dispositivo_de_computacionService {
    //Listar
    List<Dispositivo_de_computacion> findAll();

    //Guardar
    Dispositivo_de_computacion save(Dispositivo_de_computacion computadora);

    // Actualizar
    Dispositivo_de_computacion update(int id, Dispositivo_de_computacion computadora);

    //Eliminar
    void delete(int id);
}
