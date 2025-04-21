package com.proyecto.EasyIT.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@NamedStoredProcedureQuery(
        name = "LogTicket.getAllLog",
        procedureName = "pkg_log_ticket.sp_get_log_ticket",
        resultClasses = LogTicket.class,
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class)
        }
)
@Data
@Entity
public class LogTicket {
    @Id
    @Column(name = "ID_LOG")
    private Integer idLog;

    @Column(name = "ID_TICKET")
    private Integer idTicket;

    @Column(name = "FECHA_CAMBIO")
    private Date fechaCambio;

    @Column(name = "NUEVO_STATUS")
    private String nuevoStatus;
}
