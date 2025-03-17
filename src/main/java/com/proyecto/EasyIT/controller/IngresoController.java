package com.proyecto.EasyIT.controller;

import com.proyecto.EasyIT.Model.Ingreso;
import com.proyecto.EasyIT.Service.IngresoService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/ingreso")
public class IngresoController {

    @Autowired
    private IngresoService ingresoService;

    @GetMapping("listar")
    public List<Ingreso> getAll() {
        return ingresoService.findAll();
    }

    @PostMapping("guardar")
    public IngresoService create(Ingreso ingreso) {
        return (IngresoService) ingresoService.save(ingreso);
    }

    @PutMapping("actualizar")
    public IngresoService update(int id, Ingreso ingreso) {
        return (IngresoService) ingresoService.update(id, ingreso);
    }

    @DeleteMapping("eliminar")
    public void delete(int id) {
        ingresoService.delete(id);
    }
}

