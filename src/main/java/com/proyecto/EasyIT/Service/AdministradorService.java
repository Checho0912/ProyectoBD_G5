package com.proyecto.EasyIT.Service;

import com.proyecto.EasyIT.Model.Administrador;

import java.util.List;

public interface AdministradorService {
    //Listar
    List<Administrador> findAll();

    //Guardar
    Administrador save(Administrador administrador);

    // Actualizar
    Administrador update(int id, Administrador administrador);

    //Eliminar
    void delete(int id);

}
