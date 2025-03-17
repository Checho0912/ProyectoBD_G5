package com.proyecto.EasyIT.Service;

import com.proyecto.EasyIT.Model.Devolucion;

import java.util.List;

public interface DevolucionService {
    //Listar
    List<Devolucion> findAll();

    //Guardar
    Devolucion save(Devolucion devolucion);

    // Actualizar
    Devolucion update(int id, Devolucion devolucion);

    //Eliminar
    void delete(int id);

}
