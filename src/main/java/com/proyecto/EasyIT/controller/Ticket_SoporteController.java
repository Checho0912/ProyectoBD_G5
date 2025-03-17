package com.proyecto.EasyIT.controller;

import com.proyecto.EasyIT.Model.Ticket_Soporte;
import com.proyecto.EasyIT.Service.Ticket_SoporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets/soporte")
public class Ticket_SoporteController {
    @Autowired
    private Ticket_SoporteService soporteService;

    @GetMapping("/listado")
    public List<Ticket_Soporte> getAll() {
        return soporteService.findAll();
    }

    @PostMapping("/crear")
    public Ticket_Soporte create(Ticket_Soporte ticket) {
        return soporteService.save(ticket);
    }

    @PutMapping("/actualizar")
    public Ticket_Soporte update(int id, Ticket_Soporte ticket) {
        return soporteService.update(id, ticket);
    }

    @DeleteMapping("/eliminar")
    public void delete(int id) {
        soporteService.delete(id);
    }
}