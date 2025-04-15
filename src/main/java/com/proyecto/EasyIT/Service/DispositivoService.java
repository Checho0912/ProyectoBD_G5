package com.proyecto.EasyIT.Service;

import com.proyecto.EasyIT.Model.Dispositivo;
import com.proyecto.EasyIT.Model.Dispositivo_de_computacion;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DispositivoService {

    public List<Dispositivo> getDispositivos();//READ

    public void saveDispositivo(Dispositivo dispositivo);

    public void deleteDispositivo(Dispositivo dispositivo);

    public List<Dispositivo> GET_ALL_DISPOSITIVOS();
}
