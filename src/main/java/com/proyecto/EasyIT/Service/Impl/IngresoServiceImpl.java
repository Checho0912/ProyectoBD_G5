package com.proyecto.EasyIT.Service.Impl;

import com.proyecto.EasyIT.Dao.IngresoDAO;
import com.proyecto.EasyIT.Model.Ingreso;
import com.proyecto.EasyIT.Service.IngresoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngresoServiceImpl implements IngresoService {
    @Autowired
    private IngresoDAO ingresoDAO;

    @Override
    @Transactional
    public List<Ingreso> obtenerIngresos() {
        return ingresoDAO.getAll();
    }
}
