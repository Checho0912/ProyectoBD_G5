package com.proyecto.EasyIT.Service;

import com.proyecto.EasyIT.Model.Entrega;

import java.util.List;

public interface EntregaService {
    //Listar
    List<Entrega> findAll();

    //Guardar
    Entrega save(Entrega entrega);

    // Actualizar
    Entrega update(int id, Entrega entrega);

    //Eliminar
    void delete(int id);

}
