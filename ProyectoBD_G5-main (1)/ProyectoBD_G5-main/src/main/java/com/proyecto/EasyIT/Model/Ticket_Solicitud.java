package com.proyecto.EasyIT.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "TICKET_SOLICITUD")
public class Ticket_Solicitud implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TICKET")
    private int idTicket;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "FECHA")
    private LocalDate fecha;

    @Column(name = "FECHA_RESOLUCION")
    private LocalDate fechaResolucion;

    @Column(name = "ID_ADMINISTRADOR")
    private int idAdministrador;

    @Column(name = "ID_USUARIO")
    private int idUsuario;

    @Column(name = "TIPO_SOLICITUD")
    private String tipoSolicitud;

    public Ticket_Solicitud() {
    }

    public Ticket_Solicitud(int idTicket, String descripcion, LocalDate fecha, int idUsuario,
                            int idAdministrador, LocalDate fechaResolucion, String tipoSolicitud) {
        this.idTicket = idTicket;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
        this.idAdministrador = idAdministrador;
        this.fechaResolucion = fechaResolucion;
        this.tipoSolicitud = tipoSolicitud;
    }
}
