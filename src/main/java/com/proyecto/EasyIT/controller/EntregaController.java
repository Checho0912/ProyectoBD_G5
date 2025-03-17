package com.proyecto.EasyIT.controller;

import com.proyecto.EasyIT.Model.Entrega;
import com.proyecto.EasyIT.Model.Usuario;
import com.proyecto.EasyIT.Service.EntregaService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/Entrega")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @GetMapping("listar")
    public List<Entrega> getAll() {
        return entregaService.findAll();
    }

    @PostMapping("guardar")
    public Entrega create(Entrega entrega) {
        return entregaService.save(entrega);
    }

    @PutMapping("actualizar")
    public Entrega update(int id, Entrega entrega) {
        return entregaService.update(id, entrega);
    }

    @DeleteMapping("eliminar")
    public void delete(int id) {
        entregaService.delete(id);
    }
}

