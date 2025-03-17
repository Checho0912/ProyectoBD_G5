package com.proyecto.EasyIT.Service;

import com.proyecto.EasyIT.Model.Ingreso;

import java.util.List;

public interface IngresoService {
    //Listar
    List<Ingreso> findAll();

    //Guardar
    Ingreso save(Ingreso ingreso);

    // Actualizar
    Ingreso update(int id, Ingreso ingreso);

    //Eliminar
    void delete(int id);

}
