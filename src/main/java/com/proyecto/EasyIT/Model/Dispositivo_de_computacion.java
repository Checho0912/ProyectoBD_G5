package com.proyecto.EasyIT.Model;


import com.proyecto.EasyIT.Dao.Dispositivo_de_computacionDAO;
import jakarta.persistence.*;

import lombok.Data;

import java.io.Serializable;


@Data
@Entity
@Table(name= "DISPOSITIVO_DE_COMPUTACION")
public class Dispositivo_de_computacion implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID_COMPUTADORA")
    private int IdComputadora;
    private int usuario;
    private String manufacturador;
    private String modelo;
    private String numeroSerial;


    Dispositivo_de_computacion(){}
}
