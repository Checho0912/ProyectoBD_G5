package com.proyecto.EasyIT.Dao;

import com.proyecto.EasyIT.Model.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface IngresoDAO extends JpaRepository<Ingreso,Long> {
    @Procedure(name = "Ingreso.getAll")
    List<Ingreso> getAll();
}
