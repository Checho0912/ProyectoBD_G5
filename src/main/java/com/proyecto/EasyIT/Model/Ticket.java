package com.proyecto.EasyIT.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "TICKET")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "Ticket.getAll",
                procedureName = "pkg_ticket.sp_get_all_tickets",
                resultClasses = Ticket.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "Ticket.getById",
                procedureName = "pkg_ticket.sp_get_ticket_by_id",
                resultClasses = Ticket.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR,name="p_cursor", type = void.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "Ticket.delete",
                procedureName = "pkg_ticket.sp_delete_ticket",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id", type = Integer.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "Ticket.getEnEspera",
                procedureName = "pkg_ticket.sp_get_tickets_espera",
                resultClasses = Ticket.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "Ticket.getAsignando",
                procedureName = "pkg_ticket.sp_get_tickets_asignando",
                resultClasses = Ticket.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "Ticket.getFinalizado",
                procedureName = "pkg_ticket.sp_get_tickets_finalizado",
                resultClasses = Ticket.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class)
                }
        ),
        @NamedStoredProcedureQuery(
        name = "Ticket.getReparando",
        procedureName = "pkg_ticket.sp_get_tickets_reparacion",
        resultClasses = Ticket.class,
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class)
        }
),
        @NamedStoredProcedureQuery(
                name = "Ticket.getConTipoNombre",
                procedureName = "pkg_ticket.sp_get_tickets_con_tipo_nombre",
                resultClasses = Ticket.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class)
                }
        ),
        @NamedStoredProcedureQuery(
        name = "Ticket.crearTicket",
        procedureName = "pkg_ticket.sp_crear_ticket",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tipo_ticket", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_dispositivo", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_descripcion", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_usuario", type = Integer.class),

        }
        ),
        @NamedStoredProcedureQuery(
                name = "Ticket.asignarTicketAdministrador",
                procedureName = "pkg_ticket.sp_asignar_ticket_administrador",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_ticket", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_administrador", type = Integer.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "Ticket.iniciarResolucion",
                procedureName = "pkg_ticket.sp_iniciar_resolucion_ticket",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_ticket", type = Integer.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "Ticket.finalizarResolucion",
                procedureName = "pkg_ticket.sp_finalizar_resolucion_ticket",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_ticket", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_acciones_tomadas", type = String.class)
                }
        )
})
public class Ticket {
    @Id
    @Column(name = "ID_TICKET")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTicket;

    @Column(name = "TIPO_TICKET")
    private Integer tipoTicket;

    @Column(name = "ID_DISPOSITIVO")
    private Integer idDispositivo;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "FECHA_INGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "FECHA_RESOLUCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaResolucion;

    @Column(name = "ACCIONES_TOMADAS")
    private String accionesTomadas;

    @Column(name = "ID_ADMINISTRADOR")
    private Integer idAdministrador;

    @Column(name = "ID_USUARIO")
    private Integer idUsuario;
}
