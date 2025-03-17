package com.proyecto.EasyIT.controller;

import com.proyecto.EasyIT.Model.Devolucion;
import com.proyecto.EasyIT.Service.DevolucionService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/devolucion")
public class DevolucionController {

    @Autowired
    private DevolucionService devolucionService;

    @GetMapping("listar")
    public List<Devolucion> getAll() {
        return devolucionService.findAll();
    }

    @PostMapping("guardar")
    public Devolucion create(Devolucion devolucion) {
        return devolucionService.save(devolucion);
    }

    @PutMapping("actualizar")
    public Devolucion update(int id, Devolucion devolucion) {
        return devolucionService.update(id, devolucion);
    }

    @DeleteMapping("eliminar")
    public void delete(int id) {
        devolucionService.delete(id);
    }
}

