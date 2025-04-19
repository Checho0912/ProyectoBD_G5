package com.proyecto.EasyIT.Service.Impl;


import com.proyecto.EasyIT.Dao.DispositivoDAO;
import com.proyecto.EasyIT.Model.Dispositivo;

import com.proyecto.EasyIT.Model.Requests.TipoDispositivoCount;
import com.proyecto.EasyIT.Service.DispositivoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DispositivoServiceImpl implements DispositivoService {
    @Autowired
    private DispositivoDAO dispositivoDao;

    // Lectura general por JPA
    @Transactional
    @Override
    public List<Dispositivo> getDispositivos() {
        return dispositivoDao.findAll();
    }

    // Guardar (crear o actualizar por JPA)
    @Transactional
    @Override
    public void saveDispositivo(Dispositivo dispositivo) {
        dispositivoDao.save(dispositivo);
    }

    // Eliminar por JPA
    @Transactional
    @Override
    public void deleteDispositivo(Dispositivo dispositivo) {
        dispositivoDao.delete(dispositivo);
    }

    // Procedimiento almacenado: Obtener todos
    @Transactional
    @Override
    public List<Dispositivo> GET_ALL_DISPOSITIVOS() {
        return dispositivoDao.getAll();
    }

    // Procedimiento almacenado: Obtener por ID
    @Transactional
    @Override
    public List<Dispositivo> GET_DISPOSITIVO_BY_ID(Integer id) {
        return dispositivoDao.getDispositivoById(id);
    }

    // Procedimiento almacenado: Insertar
    @Transactional
    @Override
    public void INSERT_DISPOSITIVO(String tipo, String marca, String modelo, String serial, Integer idUsuario, String status) {
        dispositivoDao.insertDispositivo(tipo, marca, modelo, serial, idUsuario, status);
    }

    // Procedimiento almacenado: Actualizar
    @Transactional
    @Override
    public void UPDATE_DISPOSITIVO(Integer id, String tipo, String marca, String modelo, String serial, Integer idUsuario, String status) {
        dispositivoDao.updateDispositivo(id, tipo, marca, modelo, serial, idUsuario, status);
    }

    // Procedimiento almacenado: Eliminar
    @Transactional
    @Override
    public void DELETE_DISPOSITIVO(Integer id) {
        dispositivoDao.deleteDispositivo(id);
    }

    // Procedimiento almacenado: Insertar simple
    @Transactional
    @Override
    public void GENERAR_DISPOSITIVO(String tipo, String fabricante, String modelo, String numeroSerial) {
        dispositivoDao.generarDispositivo(tipo, fabricante, modelo, numeroSerial);
    }

    // Procedimiento almacenado: Vistas
    @Transactional
    @Override
    public List<Dispositivo> GET_DISPOSITIVOS_DISPONIBLES() {
        return dispositivoDao.getDisponibles();
    }

    @Transactional
    @Override
    public List<Dispositivo> GET_DISPOSITIVOS_ASIGNADOS() {
        return dispositivoDao.getAsignados();
    }

    @Transactional
    @Override
    public List<Dispositivo> GET_DISPOSITIVOS_EN_REPARACION() {
        return dispositivoDao.getEnReparacion();
    }

    @Transactional
    @Override
    public List<TipoDispositivoCount> GET_DISPOSITIVOS_POR_TIPO() {
        return dispositivoDao.getPorTipo();
    }
}
