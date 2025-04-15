package com.proyecto.EasyIT.Service.Impl;


import com.proyecto.EasyIT.Dao.DispositivoDAO;
import com.proyecto.EasyIT.Model.Dispositivo;

import com.proyecto.EasyIT.Service.DispositivoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispositivoServiceImpl implements DispositivoService {
    @Autowired
    private DispositivoDAO dispositivoDao;

    //read
    @Transactional
    @Override
    public List<Dispositivo> getDispositivos() {
        var listaDispositivos = dispositivoDao.findAll();

        return listaDispositivos;
    }

    //create y update
    @Transactional
    @Override
    public void saveDispositivo(Dispositivo dispositivo){
        dispositivoDao.save(dispositivo);
    }
    //delete
    @Transactional
    @Override
    public void deleteDispositivo(Dispositivo dispositivo){
        dispositivoDao.delete(dispositivo);
    }

    @Transactional
    @Override
    public List<Dispositivo> GET_ALL_DISPOSITIVOS(){
        return dispositivoDao.getAll();
    }

    @Transactional
    @Override
    public void CREATE_DISPOSITIVO(String tipo, String marca, String modelo, String serial, Integer idUsuario){
        dispositivoDao.createDispositivo(tipo, marca, modelo, serial, idUsuario);
    }

    @Transactional
    @Override
    public void DELETE_DISPOSITIVO(Integer id){
        dispositivoDao.deleteDispositivo(id);
    }

    @Transactional
    @Override
    public void UPDATE_DISPOSITIVO(Integer id,String tipo, String marca, String modelo, String serial, Integer idUsuario){
        dispositivoDao.updateDispositivo(id,tipo,marca,modelo,serial,idUsuario);
    }
}
