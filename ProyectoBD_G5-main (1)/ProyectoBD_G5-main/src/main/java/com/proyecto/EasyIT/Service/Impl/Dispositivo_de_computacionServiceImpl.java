package com.proyecto.EasyIT.Service.Impl;

import com.proyecto.EasyIT.Dao.Dispositivo_de_computacionDAO;
import com.proyecto.EasyIT.Model.Dispositivo_de_computacion;

import com.proyecto.EasyIT.Service.Dispositivo_de_computacionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Dispositivo_de_computacionServiceImpl implements Dispositivo_de_computacionService {

    @Autowired
    private Dispositivo_de_computacionDAO computadoraDao;

    @Transactional
    @Override
    public List<Dispositivo_de_computacion> getComputadoras() {
       var listaComputadoras = computadoraDao.findAll();


       return listaComputadoras;
    }
//
//    @Override
//    public Dispositivo_de_computacion getComputadora(int id){
//        return computadoraDao.findById(id).get();
//    }
//
//    @Override
//    public void deleteComputadora(int idComputadora) {
//        computadoraDao.deleteById(idComputadora);
//    }
//
//    @Override
//    public void saveComputadora(Dispositivo_de_computacion computadora) {
//        computadoraDao.save(computadora);
//    }
}
