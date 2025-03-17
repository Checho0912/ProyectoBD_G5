package com.proyecto.EasyIT.controller;

import com.proyecto.EasyIT.Model.Ticket_Averia;
import com.proyecto.EasyIT.Service.Ticket_AveriaService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets/averia")
public class Ticket_AveriaController {

    @Autowired
    private Ticket_AveriaService averiaService;

    @GetMapping("/listado")
    public List<Ticket_Averia> getAll() {
        return averiaService.findAll();
    }

    @PostMapping("crear")
    public Ticket_Averia create(Ticket_Averia ticket) {
        return averiaService.save(ticket);
    }

    @PutMapping("/actualizar")
    public Ticket_Averia update(int id, Ticket_Averia ticket) {
        return averiaService.update(id, ticket);
    }

    @DeleteMapping("/eliminar")
    public void delete(int id) {
        averiaService.delete(id);
    }
}





