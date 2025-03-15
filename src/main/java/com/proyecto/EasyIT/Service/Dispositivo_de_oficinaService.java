package com.proyecto.EasyIT.Service;

import com.proyecto.EasyIT.Model.Dispositivo_de_oficina;
import java.util.List;

public interface Dispositivo_de_oficinaService {
    List<Dispositivo_de_oficina> getDispositivos();
    Dispositivo_de_oficina getDispositivoById(Long id);
    void saveDispositivo(Dispositivo_de_oficina dispositivo);
    void deleteDispositivo(Long id);
}
