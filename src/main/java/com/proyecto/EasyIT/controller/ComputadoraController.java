package com.proyecto.EasyIT.controller;

import com.proyecto.EasyIT.Model.Dispositivo_de_computacion;
import com.proyecto.EasyIT.Service.Dispositivo_de_computacionService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/computadora/queries")
@CrossOrigin
public class ComputadoraController {

    @Autowired
    Dispositivo_de_computacionService computadoraService;


    @GetMapping("/get")
    public List<Dispositivo_de_computacion> getAll(){

        List<Dispositivo_de_computacion> computadoras = computadoraService.getComputadoras();
        return computadoras;
    }

}
