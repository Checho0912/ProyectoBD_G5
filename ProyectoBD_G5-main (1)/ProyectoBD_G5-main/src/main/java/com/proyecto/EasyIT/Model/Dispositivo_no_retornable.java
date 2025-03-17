package com.proyecto.EasyIT.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "DISPOSITIVO_NO_RETORNABLE")
public class DispositivoNoRetornable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DISPOSITIVO")
    private int idDispositivo;

    @Column(name = "USUARIO")
    private int usuario;

    @Column(name = "MANUFACTURADOR")
    private String manufacturador;

    @Column(name = "MODELO")
    private String modelo;

    public DispositivoNoRetornable(int usuario, String manufacturador, String modelo) {
        this.usuario = usuario;
        this.manufacturador = manufacturador;
        this.modelo = modelo;
    }
}


