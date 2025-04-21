package com.proyecto.EasyIT.Dao;

import com.proyecto.EasyIT.Model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface EntregaDAO extends JpaRepository<Entrega,Long> {
    @Procedure(name = "Entrega.getAllEntregas")
    List<Entrega> getAllEntregas();
}
