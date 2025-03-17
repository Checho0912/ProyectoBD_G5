package com.proyecto.EasyIT.Service;

import com.proyecto.EasyIT.Model.Ticket_Averia;

import java.util.List;

public interface Ticket_AveriaService {
    //Listar
    List<Ticket_Averia> findAll();

    //Guardar
    Ticket_Averia save(Ticket_Averia ticket);

    // Actualizar
    Ticket_Averia update(int id, Ticket_Averia ticket);

    //Eliminar
    void delete(int id);

}
