package com.proyecto.EasyIT.Service;

import com.proyecto.EasyIT.Model.Ticket;

import java.util.List;

public interface TicketService {

    // CRUD operations
    List<Ticket> getAllTickets();                         // READ ALL
    List<Ticket> getTicketById(Integer id);               // READ BY ID
    void deleteTicket(Integer id);                        // DELETE

    // Views
    List<Ticket> getTicketsEnEspera();                    // View: 'ESPERA'
    List<Ticket> getTicketsEnAsignando();                 // View: 'ASIGNANDO'
    List<Ticket> getTicketsFinalizados();                 // View: 'FINALIZADO'
    List<Ticket> getTicketsReparando();                 // View: 'REPARANDO'
    List<Ticket> getTicketsConNombreTipo();               // View JOIN with TipoTicket
    void crearTicket(Integer tipoTicket, Integer idDispositivo, String descripcion, Integer idUsuario);
    void asignarTicketAdministrador(Integer idTicket, Integer idAdministrador);
    void iniciarResolucionTicket(Integer idTicket);
    void finalizarResolucion(Integer idTicket, String accionesTomadas);
}
