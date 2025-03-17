package com.proyecto.EasyIT.controller;

import com.proyecto.EasyIT.Model.Administrador;
import com.proyecto.EasyIT.Service.AdministradorService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@RestController
@RequestMapping("/computadora/queries")
public class AdministradorController {


    @Autowired
    private AdministradorService administradorService; //No sé por qué da error...

    @GetMapping("listar")
    public List<Administrador> getAll() {
        return administradorService.findAll();
    }

    @PostMapping("/guardar")
    public Administrador create(Administrador administrador) {
        return administradorService.save(administrador);
    }

    @PutMapping("actualizar")
    public Administrador update(int id, Administrador administrador) {
        return administradorService.update(id, administrador);
    }

    @DeleteMapping("eliminar")
    public void delete(int id) {
        administradorService.delete(id);
    }

}
