package com.proyecto.EasyIT.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "INGRESO")
public class Ingreso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_INGRESO")
    private int idIngreso;

    @Column(name = "FECHA_INGRESO")
    private LocalDate fechaIngreso;

    @Column(name = "ID_DISPOSITIVO")
    private int idDispositivo;

    @Column(name = "NUMERO_SERIAL")
    private String numeroSerial;

    public Ingreso() {
    }

    public Ingreso(int idIngreso, LocalDate fechaIngreso, int idDispositivo, String numeroSerial) {
        this.idIngreso = idIngreso;
        this.fechaIngreso = fechaIngreso;
        this.idDispositivo = idDispositivo;
        this.numeroSerial = numeroSerial;
    }
}
