package com.proyecto.EasyIT.Model;


import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "DISPOSITIVO_DE_OFICINA")
public class Dispositivo_de_oficina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DISPOSITIVO")
    private Long idDispositivo;

    @Column(name = "TIPO_DISPOSITIVO")
    private String tipoDispositivo;

    @Column(name = "NUMERO_SERIAL")
    private String numeroSerial;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    public Dispositivo_de_oficina() {}
}