package com.proyecto.EasyIT.controller;

import com.proyecto.EasyIT.Model.Dispositivo_de_oficina;
import com.proyecto.EasyIT.Service.Dispositivo_de_oficinaService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/oficina/queries")
@CrossOrigin
public class OficinaController {

    @Autowired
    Dispositivo_de_oficinaService oficinaService;

    @GetMapping("/get")
    public List<Dispositivo_de_oficina> getAll() {
        return oficinaService.getDispositivos();
    }

    @GetMapping("/get/{id}")
    public Dispositivo_de_oficina getById(@PathVariable Long id) {
        return oficinaService.getDispositivoById(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody Dispositivo_de_oficina dispositivo) {
        oficinaService.saveDispositivo(dispositivo);
    }

    @PutMapping("/update")
    public void update(@RequestBody Dispositivo_de_oficina dispositivo) {
        oficinaService.saveDispositivo(dispositivo);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        oficinaService.deleteDispositivo(id);
    }
}
