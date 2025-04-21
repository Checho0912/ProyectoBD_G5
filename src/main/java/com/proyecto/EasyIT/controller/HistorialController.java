package com.proyecto.EasyIT.controller;

import com.proyecto.EasyIT.Model.Entrega;
import com.proyecto.EasyIT.Model.Ingreso;
import com.proyecto.EasyIT.Model.LogTicket;
import com.proyecto.EasyIT.Service.EntregaService;
import com.proyecto.EasyIT.Service.IngresoService;
import com.proyecto.EasyIT.Service.LogTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/historial")
@CrossOrigin
public class HistorialController {

    @Autowired
    private EntregaService entregaService;

    @Autowired
    private IngresoService ingresoService;

    @Autowired
    private LogTicketService logTicketService;

    @GetMapping("/entregas")
    public ResponseEntity<List<Entrega>> getAllEntregas() {
        List<Entrega> entregas = entregaService.obtenerTodasLasEntregas();
        return ResponseEntity.ok(entregas);
    }

    @GetMapping("/ingresos")
    public ResponseEntity<List<Ingreso>> obtenerIngresos() {
        return ResponseEntity.ok(ingresoService.obtenerIngresos());
    }
    @GetMapping("/logTickets")
    public ResponseEntity<List<LogTicket>> obtenerLogs() {
        return ResponseEntity.ok(logTicketService.obtenerLogTickets());
    }
}
