package com.proyecto.EasyIT.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@NamedStoredProcedureQuery(
        name = "Ingreso.getAll",
        procedureName = "pkg_ingreso.sp_get_all_ingresos",
        resultClasses = Ingreso.class,
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR,name = "p_cursor", type = Ingreso.class)
        }
)
@Data
@Entity
@Table(name = "INGRESO")
public class Ingreso {
    @Id
    @Column(name = "ID_INGRESO")
    private Integer idIngreso;

    @Column(name = "FECHA_INGRESO")
    private Date fechaIngreso;

    @Column(name = "ID_DISPOSITIVO")
    private Integer idDispositivo;

    // Getters and Setters
}