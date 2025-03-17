package com.proyecto.EasyIT.controller;

import com.proyecto.EasyIT.Model.Dispositivo_de_oficina;
import com.proyecto.EasyIT.Service.Dispositivo_de_oficinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dispositivos/oficina")
public class Dispositivo_de_OficinaController {
    @Autowired
    private Dispositivo_de_oficinaService oficinaService;

    @GetMapping("/listar")
    public List<Dispositivo_de_oficina> getAll() {
        return oficinaService.findAll();
    }

    @PostMapping("/crear")
    public Dispositivo_de_oficina create(Dispositivo_de_oficina dispositivo) {
        return oficinaService.save(dispositivo);
    }

    @PutMapping("/actualizar")
    public Dispositivo_de_oficina update(int id, Dispositivo_de_oficina dispositivo) {
        return oficinaService.update(id, dispositivo);
    }

    @DeleteMapping("/eliminar")
    public void delete(int id) {
        oficinaService.delete(id);
    }
}
