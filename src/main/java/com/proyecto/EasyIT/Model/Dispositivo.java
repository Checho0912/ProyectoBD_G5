package com.proyecto.EasyIT.Model;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name= "DISPOSITIVO")

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "Dispositivo.getAll",
                procedureName = "GET_ALL_DISPOSITIVOS",
                resultClasses = Dispositivo.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "p_cursor", type = void.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "Dispositivo.getById",
                procedureName = "GET_DISPOSITIVO_BY_ID",
                resultClasses = Dispositivo.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_idDispositivo", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "p_cursor", type = void.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "Dispositivo.create",
                procedureName = "CREATE_DISPOSITIVO",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_TipoDispositivo", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_manufacturador", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_modelo", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numeroSerial", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_idUsuario", type = Integer.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "Dispositivo.update",
                procedureName = "UPDATE_DISPOSITIVO",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_idDispositivo", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_TipoDispositivo", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_manufacturador", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_modelo", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numeroSerial", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_idUsuario", type = Integer.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "Dispositivo.delete",
                procedureName = "DELETE_DISPOSITIVO",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_idDispositivo", type = Integer.class)
                }
        )
})

public class Dispositivo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID_Dispositivo")
    private int idDispositivo;
    private String TipoDispositivo;
    private String manufacturador;
    private String modelo;
    private String numeroSerial;
    private int idUsuario;

}
