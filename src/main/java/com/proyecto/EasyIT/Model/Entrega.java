package com.proyecto.EasyIT.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name="ENTREGA")
public class Entrega implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ENTREGA")
    private int idEntrega;

    @Column(name = "FECHA_ENTREGA")
    private LocalDate fechaEntrega;

    @Column(name = "ID_DISPOSITIVO")
    private int idDispositivo;

    @Column(name = "NUMERO_SERIAL")
    private String numeroSerial;

    @Column(name = "TIPO_DISPOSITIVO")
    private String tipoDispositivo;

    public Entrega() {
    }

    public Entrega(int idEntrega, LocalDate fechaEntrega, int idDispositivo, String tipoDispositivo, String numeroSerial) {
        this.idEntrega = idEntrega;
        this.fechaEntrega = fechaEntrega;
        this.idDispositivo = idDispositivo;
        this.tipoDispositivo = tipoDispositivo;
        this.numeroSerial = numeroSerial;
    }
}
