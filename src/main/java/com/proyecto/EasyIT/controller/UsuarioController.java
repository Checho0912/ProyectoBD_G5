package com.proyecto.EasyIT.controller;

import com.proyecto.EasyIT.Model.Usuario;
import com.proyecto.EasyIT.Service.UsuarioService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("listar")
    public List<Usuario> getAll() {
        return usuarioService.findAll();
    }

    @PostMapping("guardar")
    public Usuario create(Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PutMapping("actualizar")
    public Usuario update(int id, Usuario usuario) {
        return usuarioService.update(id, usuario);
    }

    @DeleteMapping("eliminar")
    public void delete(int id) {
        usuarioService.delete(id);
    }
}

