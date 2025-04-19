package com.proyecto.EasyIT.Model.Requests;

import lombok.Data;

@Data
public class TipoDispositivoCount {
    private String tipoDispositivo;
    private Long total;

    public TipoDispositivoCount(String tipoDispositivo, Long total) {
        this.tipoDispositivo = tipoDispositivo;
        this.total = total;
    }
}
