package com.proyecto.EasyIT.Service.Impl;

import com.proyecto.EasyIT.Dao.EntregaDAO;
import com.proyecto.EasyIT.Model.Entrega;
import com.proyecto.EasyIT.Service.EntregaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EntregaServiceImpl implements EntregaService {

    @Autowired
    private EntregaDAO entregaDAO;

    @Override
    @Transactional
    public List<Entrega> obtenerTodasLasEntregas() {
        return entregaDAO.getAllEntregas();
    }
}
