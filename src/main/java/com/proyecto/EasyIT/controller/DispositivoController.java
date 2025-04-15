package com.proyecto.EasyIT.controller;

import com.proyecto.EasyIT.Model.Dispositivo;
import com.proyecto.EasyIT.Service.DispositivoService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@CrossOrigin
@RequestMapping("/dispositivo")

public class DispositivoController {
    @Autowired
    DispositivoService dispositivoService;

    //Read
    @GetMapping("/getAll")
    public List<Dispositivo> getDispositivos(){

        List<Dispositivo> dispositivos = dispositivoService.getDispositivos();
        return dispositivos;
    }

    //Create y update
    @PostMapping("/create")
    public void createDispositivo(@RequestBody Dispositivo dispositivo) {
        dispositivoService.saveDispositivo(dispositivo);
    }

    //Delete
    @PostMapping("/delete")
    public void deleteDispositivo(@RequestBody Dispositivo dispositivo){
        dispositivoService.deleteDispositivo(dispositivo);
    }

    //Procedimientos almacenados
    @GetMapping("/getProcedure")
    public List<Dispositivo> getAllProcedure(){
        return dispositivoService.GET_ALL_DISPOSITIVOS();
    }

    //CREATE procedure

    @PostMapping("/createProcedure")
    public ResponseEntity<String> createProcedure(@RequestBody Dispositivo dto) {
        dispositivoService.CREATE_DISPOSITIVO(
                dto.getTipoDispositivo(),
                dto.getManufacturador(),
                dto.getModelo(),
                dto.getNumeroSerial(),
                dto.getIdUsuario()
        );
        return ResponseEntity.ok("Dispositivo creado exitosamente.");
    }

    //DELETE PROCEDURE

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDispositivo(@PathVariable Integer id) {
        dispositivoService.DELETE_DISPOSITIVO(id);
        return ResponseEntity.ok("Dispositivo eliminado exitosamente.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDispositivo(@PathVariable Integer id, @RequestBody Dispositivo dto) {
        dispositivoService.UPDATE_DISPOSITIVO(
                id,
                dto.getTipoDispositivo(),
                dto.getManufacturador(),
                dto.getModelo(),
                dto.getNumeroSerial(),
                dto.getIdUsuario()
        );
        return ResponseEntity.ok("Dispositivo actualizado exitosamente.");
    }


}
