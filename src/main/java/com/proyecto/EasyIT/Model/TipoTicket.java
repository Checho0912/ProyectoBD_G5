package com.proyecto.EasyIT.Model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "TIPO_TICKET")
@NamedStoredProcedureQuery(
        name = "TipoTicket.getAllTipoTickets",
        procedureName = "PKG_TipoTickets.sp_get_all_tipo_tickets",
        resultClasses = TipoTicket.class,
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class)
        })
@Data
public class TipoTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_TICKET")
    private Integer idTipoTicket;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "DESCRIPCION", length = 250)
    private String descripcion;
}
