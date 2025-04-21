package com.proyecto.EasyIT.Service;

import com.proyecto.EasyIT.Model.Dispositivo;
import com.proyecto.EasyIT.Model.Requests.TipoDispositivoCount;

import java.util.List;
import java.util.Map;

public interface DispositivoService {

    public List<Dispositivo> getDispositivos();//READ

    public void saveDispositivo(Dispositivo dispositivo);

    public void deleteDispositivo(Dispositivo dispositivo);

    public List<Dispositivo> GET_ALL_DISPOSITIVOS();

    public List<Dispositivo> GET_DISPOSITIVO_BY_ID(Integer id);

    public void INSERT_DISPOSITIVO(String tipo, String marca, String modelo, String serial, Integer idUsuario, String status);

    public void DELETE_DISPOSITIVO(Integer idDispositivo);

    public void UPDATE_DISPOSITIVO(Integer id,String tipo, String marca, String modelo, String serial, Integer idUsuario,String status);

    void GENERAR_DISPOSITIVO(
            String tipo,
            String fabricante,
            String modelo,
            String numeroSerial
    );
    List<Dispositivo> GET_DISPOSITIVOS_DISPONIBLES();

    List<Dispositivo> GET_DISPOSITIVOS_ASIGNADOS();

    List<Dispositivo> GET_DISPOSITIVOS_EN_REPARACION();

    List<TipoDispositivoCount> GET_DISPOSITIVOS_POR_TIPO();// COUNT + GROUP BY

    public void SP_ASIGNAR_DISPOSITIVO(Integer idDispositivo,Integer idUsuario);
}
