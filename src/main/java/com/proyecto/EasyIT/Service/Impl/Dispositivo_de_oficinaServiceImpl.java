package com.proyecto.EasyIT.Service.Impl;

import com.proyecto.EasyIT.Dao.Dispositivo_de_oficinaDAO;
import com.proyecto.EasyIT.Model.Dispositivo_de_oficina;
import com.proyecto.EasyIT.Service.Dispositivo_de_oficinaService;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Dispositivo_de_oficinaServiceImpl implements Dispositivo_de_oficinaService {

    @Autowired
    private Dispositivo_de_oficinaDAO oficinaDao;

    @Transactional
    @Override
    public List<Dispositivo_de_oficina> getDispositivos() {
        return oficinaDao.findAll();
    }

    @Transactional
    @Override
    public Dispositivo_de_oficina getDispositivoById(Long id) {
        return oficinaDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void saveDispositivo(Dispositivo_de_oficina dispositivo) {
        oficinaDao.save(dispositivo);
    }

    @Transactional
    @Override
    public void deleteDispositivo(Long id) {
        oficinaDao.deleteById(id);
    }
}
