package com.proyecto.EasyIT.controller;

import com.proyecto.EasyIT.Model.Ticket;
import com.proyecto.EasyIT.Model.TipoTicket;
import com.proyecto.EasyIT.Service.TicketService;
import com.proyecto.EasyIT.Service.TipoTicketService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@CrossOrigin
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private TipoTicketService tipoTicketService;
    // Obtener todos los tickets
    @GetMapping("/getAll")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    // Obtener ticket por ID
    @GetMapping("/getById/{id}")
    public List<Ticket> getTicketById(@PathVariable Integer id) {
        return ticketService.getTicketById(id);
    }

    // Eliminar ticket por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable Integer id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.ok("Ticket eliminado exitosamente.");
    }

    // Tickets en estado 'ESPERA'
    @GetMapping("/enEspera")
    public List<Ticket> getTicketsEnEspera() {
        return ticketService.getTicketsEnEspera();
    }

    // Tickets en estado 'ASIGNANDO'
    @GetMapping("/asignando")
    public List<Ticket> getTicketsEnAsignando() {
        return ticketService.getTicketsEnAsignando();
    }

    // Tickets en estado 'FINALIZADO'
    @GetMapping("/finalizado")
    public List<Ticket> getTicketsFinalizados() {
        return ticketService.getTicketsFinalizados();
    }
    // Tickets en estado 'Reparando'
    @GetMapping("/reparando")
    public List<Ticket> getTicketsReparando() {
        return ticketService.getTicketsReparando();
    }

    // Tickets con nombre de tipo (join con tipo_ticket)
    @GetMapping("/con-nombre-tipo")
    public List<Ticket> getTicketsConNombreTipo() {
        return ticketService.getTicketsConNombreTipo();
    }

    @PostMapping("/crearTicket")
    public ResponseEntity<String> generarTicket(@RequestBody Ticket dto) {
        ticketService.crearTicket(
                dto.getTipoTicket(),
                dto.getIdDispositivo(),
                dto.getDescripcion(),
                dto.getIdUsuario()
        );
        return ResponseEntity.ok("Ticket generado exitosamente.");
    }


    @GetMapping("/getTipos")
    public List<TipoTicket> getTipoTicket(){
        return tipoTicketService.getTipoTickets();
    }
    @PostMapping("/asignar")
    public ResponseEntity<String> asignarTicketAdministrador(@RequestParam Integer idTicket,
                                                             @RequestParam Integer idAdministrador) {
        ticketService.asignarTicketAdministrador(idTicket, idAdministrador);
        return ResponseEntity.ok("Ticket asignado correctamente.");
    }

    @PostMapping("/iniciarResolucion")
    public ResponseEntity<String> iniciarResolucion(@RequestParam("idTicket") Integer idTicket) {
        try {
            ticketService.iniciarResolucionTicket(idTicket);
            return ResponseEntity.ok("Resolución del ticket iniciada correctamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al iniciar resolución: " + e.getMessage());
        }
    }
    @PostMapping("/finalizarResolucion")
    public ResponseEntity<String> finalizarResolucion(
            @RequestParam Integer idTicket,
            @RequestParam String accionesTomadas) {

        ticketService.finalizarResolucion(idTicket, accionesTomadas);
        return ResponseEntity.ok("Ticket finalizado correctamente.");
    }

}
