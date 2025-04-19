package com.proyecto.EasyIT.controller;

import com.proyecto.EasyIT.Model.Dispositivo;
import com.proyecto.EasyIT.Model.Requests.TipoDispositivoCount;
import com.proyecto.EasyIT.Service.DispositivoService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    //Read
    @GetMapping("/get/{id}")
    public List<Dispositivo> getDispositivos(@PathVariable Integer id){
        List<Dispositivo> dispositivos = dispositivoService.GET_DISPOSITIVO_BY_ID(id);
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

    //CREATE procedures

    @PostMapping("/insertProcedure")
    public ResponseEntity<String> insertProcedure(@RequestBody Dispositivo dto) {
        dispositivoService.INSERT_DISPOSITIVO(
                dto.getTipoDispositivo(),
                dto.getManufacturador(),
                dto.getModelo(),
                dto.getNumeroSerial(),
                dto.getIdUsuario(),
                dto.getStatusActual()
        );
        return ResponseEntity.ok("Dispositivo creado exitosamente.");
    }
    // INSERT básico (sin usuario ni estado)

    @PostMapping("/insertProcedure/nuevoDispositivo")
    public ResponseEntity<String> generarDispositivo(@RequestBody Dispositivo dto) {
        dispositivoService.GENERAR_DISPOSITIVO(
                dto.getTipoDispositivo(),
                dto.getManufacturador(),
                dto.getModelo(),
                dto.getNumeroSerial()
        );
        return ResponseEntity.ok("Dispositivo generado exitosamente.");
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
                dto.getIdUsuario(),
                dto.getStatusActual()
        );
        return ResponseEntity.ok("Dispositivo actualizado exitosamente.");
    }
    // === VISTAS desde SP ===

    @GetMapping("/disponibles")
    public List<Dispositivo> getDisponibles() {
        return dispositivoService.GET_DISPOSITIVOS_DISPONIBLES();
    }

    @GetMapping("/asignados")
    public List<Dispositivo> getAsignados() {
        return dispositivoService.GET_DISPOSITIVOS_ASIGNADOS();
    }

    @GetMapping("/reparacion")
    public List<Dispositivo> getEnReparacion() {
        return dispositivoService.GET_DISPOSITIVOS_EN_REPARACION();
    }

    @GetMapping("/por-tipo")
    public List<TipoDispositivoCount> getPorTipo() {
        return dispositivoService.GET_DISPOSITIVOS_POR_TIPO();

    }

}
