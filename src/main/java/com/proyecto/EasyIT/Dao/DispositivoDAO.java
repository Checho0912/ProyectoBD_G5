package com.proyecto.EasyIT.Dao;

import com.proyecto.EasyIT.Model.Dispositivo;
import com.proyecto.EasyIT.Model.Dispositivo_de_computacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface DispositivoDAO extends JpaRepository<Dispositivo, Long> {

    @Procedure(name = "Dispositivo.getAll")
    List<Dispositivo> getAll();


    @Procedure(name = "Dispositivo.getById")
    List<Dispositivo> getById(@Param("p_idDispositivo") Integer id);

    @Procedure(name = "Dispositivo.create")
    void createDispositivo(
            @Param("p_TipoDispositivo") String tipo,
            @Param("p_manufacturador") String marca,
            @Param("p_modelo") String modelo,
            @Param("p_numeroSerial") String serial,
            @Param("p_idUsuario") Integer idUsuario
    );

    @Procedure(name = "Dispositivo.update")
    void updateDispositivo(
            @Param("p_idDispositivo") Integer id,
            @Param("p_TipoDispositivo") String tipo,
            @Param("p_manufacturador") String marca,
            @Param("p_modelo") String modelo,
            @Param("p_numeroSerial") String serial,
            @Param("p_idUsuario") Integer idUsuario
    );

    @Procedure(name = "Dispositivo.delete")
    void deleteDispositivo(@Param("p_idDispositivo") Integer id);

}
