package com.proyecto.EasyIT.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "DEVOLUCION")
public class Devolucion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DEVOLUCION")
    private int idDevolucion;

    @Column(name = "FECHA_DEVOLUCION")
    private LocalDate fechaDevolucion;

    @Column(name = "ID_DISPOSITIVO")
    private int idDispositivo;

    @Column(name = "NUMERO_SERIAL")
    private String numeroSerial;

    @Column(name = "TIPO_DISPOSITIVO")
    private String tipoDispositivo;

    public Devolucion() {
    }

    public Devolucion(int idDevolucion, LocalDate fechaDevolucion, int idDispositivo, String numeroSerial, String tipoDispositivo) {
        this.idDevolucion = idDevolucion;
        this.fechaDevolucion = fechaDevolucion;
        this.idDispositivo = idDispositivo;
        this.numeroSerial = numeroSerial;
        this.tipoDispositivo = tipoDispositivo;
    }
}


