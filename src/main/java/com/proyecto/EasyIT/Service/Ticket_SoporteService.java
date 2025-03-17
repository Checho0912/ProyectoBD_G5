package com.proyecto.EasyIT.Service;

import com.proyecto.EasyIT.Model.Ticket_Soporte;

import java.util.List;

public interface Ticket_SoporteService {
    //Listar
    List<Ticket_Soporte> findAll();

    //Guardar
    Ticket_Soporte save(Ticket_Soporte ticket);

    // Actualizar
    Ticket_Soporte update(int id, Ticket_Soporte ticket);

    //Eliminar
    void delete(int id);

}
