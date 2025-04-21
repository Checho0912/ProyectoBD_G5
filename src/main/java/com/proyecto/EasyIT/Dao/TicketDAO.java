package com.proyecto.EasyIT.Dao;

import com.proyecto.EasyIT.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketDAO extends JpaRepository<Ticket,Long> {
    @Procedure(name = "Ticket.getAll")
    List<Ticket> getAllTickets();

    @Procedure(name = "Ticket.getById")
    List<Ticket> getTicketById(@Param("p_id") Integer id);

    @Procedure(name = "Ticket.delete")
    void deleteTicket(@Param("p_id") Integer id);

    @Procedure(name = "Ticket.getEnEspera")
    List<Ticket> getEnEspera();

    @Procedure(name = "Ticket.getAsignando")
    List<Ticket> getAsignando();

    @Procedure(name = "Ticket.getFinalizado")
    List<Ticket> getFinalizado();

    @Procedure(name = "Ticket.getReparando")
    List<Ticket> getReparando();

    @Procedure(name = "Ticket.getConTipoNombre")
    List<Ticket> getConTipoNombre();

    @Procedure(name = "Ticket.crearTicket")
    void crearTicket(
            @Param("p_tipo_ticket") Integer tipoTicket,
            @Param("p_id_dispositivo") Integer idDispositivo,
            @Param("p_descripcion") String descripcion,
            @Param("p_id_usuario") Integer idUsuario
    );
    @Procedure(name = "Ticket.asignarTicketAdministrador")
    void asignarTicketAdministrador(@Param("p_id_ticket") Integer idTicket,
                                    @Param("p_id_administrador") Integer idAdministrador);

    @Procedure(name = "Ticket.iniciarResolucion")
    void iniciarResolucion(@Param("p_id_ticket") Integer idTicket);

    @Procedure(name = "Ticket.finalizarResolucion")
    void finalizarResolucion(@Param("p_id_ticket") Integer idTicket,
                             @Param("p_acciones_tomadas") String accionesTomadas);
}
