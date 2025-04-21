package com.proyecto.EasyIT.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@NamedStoredProcedureQuery(
        name = "Entrega.getAllEntregas",
        procedureName = "pkg_entrega.sp_get_all_entregas",
        resultClasses = Entrega.class,
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR,name = "p_cursor",type = Entrega.class)
        }
)
@Data
@Entity
@Table(name = "ENTREGA")
public class Entrega {
    @Id
    @Column(name = "ID_ENTREGA")
    private Integer idEntrega;

    @Column(name = "FECHA_ENTREGA")
    private Date fechaEntrega;

    @Column(name = "ID_DISPOSITIVO")
    private Integer idDispositivo;

    @Column(name = "ID_USUARIO")
    private Integer idUsuario;
}
