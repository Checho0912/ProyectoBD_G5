package com.proyecto.EasyIT.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "TICKET_SOPORTE")
public class Ticket_Soporte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TICKET")
    private int idTicket;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "FECHA")
    private LocalDate fecha;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "FECHA_RESOLUCION")
    private LocalDate fechaResolucion;

    @Column(name = "ID_ADMINISTRADOR")
    private int idAdministrador;

    @Column(name = "ID_USUARIO")
    private int idUsuario;

    public Ticket_Soporte() {
    }

    public Ticket_Soporte(String status, int idTicket, String descripcion, LocalDate fecha, LocalDate fechaResolucion, int idAdministrador, int idUsuario) {
        this.status = status;
        this.idTicket = idTicket;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.fechaResolucion = fechaResolucion;
        this.idAdministrador = idAdministrador;
        this.idUsuario = idUsuario;
    }
}
