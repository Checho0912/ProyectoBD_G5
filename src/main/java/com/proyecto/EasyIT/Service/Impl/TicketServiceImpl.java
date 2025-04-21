package com.proyecto.EasyIT.Service.Impl;

import com.proyecto.EasyIT.Dao.TicketDAO;
import com.proyecto.EasyIT.Model.Ticket;
import com.proyecto.EasyIT.Service.TicketService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketDAO ticketDAO;

    @Override
    @Transactional
    public List<Ticket> getAllTickets() {
        return ticketDAO.getAllTickets();
    }

    @Override
    @Transactional
    public List<Ticket> getTicketById(Integer id) {
        return ticketDAO.getTicketById(id);
    }

    @Override
    @Transactional
    public void deleteTicket(Integer id) {
        ticketDAO.deleteTicket(id);
    }

    @Override
    @Transactional
    public List<Ticket> getTicketsEnEspera() {
        return ticketDAO.getEnEspera();
    }

    @Override
    @Transactional
    public List<Ticket> getTicketsEnAsignando() {
        return ticketDAO.getAsignando();
    }

    @Override
    @Transactional
    public List<Ticket> getTicketsFinalizados() {
        return ticketDAO.getFinalizado();
    }

    @Override
    @Transactional
    public List<Ticket> getTicketsReparando() {
        return ticketDAO.getReparando();
    }

    @Override
    @Transactional
    public List<Ticket> getTicketsConNombreTipo() {
        return ticketDAO.getConTipoNombre();
    }
    @Override
    @Transactional
    public void crearTicket(Integer tipoTicket, Integer idDispositivo, String descripcion, Integer idUsuario) {
        ticketDAO.crearTicket(tipoTicket, idDispositivo, descripcion, idUsuario);
    }
    @Transactional
    @Override
    public void asignarTicketAdministrador(Integer idTicket, Integer idAdministrador) {
        ticketDAO.asignarTicketAdministrador(idTicket, idAdministrador);
    }
    @Override
    @Transactional
    public void iniciarResolucionTicket(Integer idTicket) {
        ticketDAO.iniciarResolucion(idTicket);
    }
    @Override
    public void finalizarResolucion(Integer idTicket, String accionesTomadas) {
        ticketDAO.finalizarResolucion(idTicket, accionesTomadas);
    }

}
