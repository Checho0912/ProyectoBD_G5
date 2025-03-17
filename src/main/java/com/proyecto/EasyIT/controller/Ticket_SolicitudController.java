package com.proyecto.EasyIT.controller;

import com.proyecto.EasyIT.Model.Ticket_Solicitud;
import com.proyecto.EasyIT.Service.Ticket_SolicitudService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/ticket/solicitud")
public class Ticket_SolicitudController {

    @Autowired
    private Ticket_SolicitudService ticketSolicitud;

    @GetMapping("listar")
    public List<Ticket_Solicitud> getAll() {
        return ticketSolicitud.findAll();
    }

    @PostMapping("guardar")
    public Ticket_Solicitud create(Ticket_Solicitud ticket) {
        return ticketSolicitud.save(ticket);
    }

    @PutMapping("actualizar")
    public Ticket_Solicitud update(int id, Ticket_Solicitud ticket) {
        return ticketSolicitud.update(id, ticket);
    }

    @DeleteMapping("eliminar")
    public void delete(int id) {
        ticketSolicitud.delete(id);
    }
}

