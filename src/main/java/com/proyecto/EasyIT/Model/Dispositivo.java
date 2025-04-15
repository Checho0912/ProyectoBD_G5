package com.proyecto.EasyIT.Model;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name= "DISPOSITIVO")

@NamedStoredProcedureQuery(
        name = "Dispositivo.getAll",
        procedureName = "GET_ALL_DISPOSITIVOS",
        resultClasses = Dispositivo.class,
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "p_cursor", type = void.class)
        }
)

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
