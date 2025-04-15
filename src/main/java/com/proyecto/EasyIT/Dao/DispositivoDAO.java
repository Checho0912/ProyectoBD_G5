package com.proyecto.EasyIT.Dao;

import com.proyecto.EasyIT.Model.Dispositivo;
import com.proyecto.EasyIT.Model.Dispositivo_de_computacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface DispositivoDAO extends JpaRepository<Dispositivo, Long> {

    @Procedure(name = "Dispositivo.getAll")
    List<Dispositivo> getAll();

}
