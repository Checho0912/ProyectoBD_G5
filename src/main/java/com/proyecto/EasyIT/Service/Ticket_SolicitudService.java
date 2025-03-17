package com.proyecto.EasyIT.Service;

import com.proyecto.EasyIT.Model.Ticket_Solicitud;

import java.util.List;

public interface Ticket_SolicitudService {
    //Listar
    List<Ticket_Solicitud> findAll();

    //Guardar
    Ticket_Solicitud save(Ticket_Solicitud ticket);

    // Actualizar
    Ticket_Solicitud update(int id, Ticket_Solicitud ticket);

    //Eliminar
    void delete(int id);

}
