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
    public List<Dispositivo> testStoredProcedure(){
        return dispositivoService.GET_ALL_DISPOSITIVOS();
    }

    //DELETE

    @PostMapping("/deleteProcedure")
    public void deleteProcedure(String id){
        dispositivoService.DELETE_DISPOSITIVO();
    }





}
