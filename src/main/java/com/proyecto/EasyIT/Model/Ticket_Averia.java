package com.proyecto.EasyIT.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name="TICKET_AVERIA")
public class Ticket_Averia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TICKET")
    private int idTicket;

    @Column(name = "ID_DISPOSITIVO")
    private int idDispositivo;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "FECHA")
    private LocalDate fecha;

    @Column(name = "FECHA_RESOLUCION")
    private String fechaResolucion;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "ID_ADMINISTRADOR")
    private int idAdministrador;

    @Column(name = "ID_USUARIO")
    private int idUsuario;

    // Constructor vacío (requerido por JPA)
    public Ticket_Averia() {
    }

    public Ticket_Averia(int idTicket, int idDispositivo, String descripcion, LocalDate fecha, String fechaResolucion, int idAdministrador, String status, int idUsuario) {
        this.idTicket = idTicket;
        this.idDispositivo = idDispositivo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.fechaResolucion = fechaResolucion;
        this.idAdministrador = idAdministrador;
        this.status = status;
        this.idUsuario = idUsuario;
    }
}
