package com.proyecto.EasyIT.Dao;

import com.proyecto.EasyIT.Model.Dispositivo;
import com.proyecto.EasyIT.Model.Requests.TipoDispositivoCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface DispositivoDAO extends JpaRepository<Dispositivo, Long> {

    @Procedure(name = "Dispositivo.getAll")
    List<Dispositivo> getAll();

    @Procedure(name = "Dispositivo.getDispositivoById")
    List<Dispositivo> getDispositivoById(@Param("p_id") Integer id);

    @Procedure(name = "Dispositivo.insertDispositivo")
    void insertDispositivo(
            @Param("p_tipo") String tipo,
            @Param("p_manufacturador") String marca,
            @Param("p_modelo") String modelo,
            @Param("p_numero_serial") String serial,
            @Param("p_id_usuario") Integer idUsuario,
            @Param("p_status") String status
    );

    @Procedure(name = "Dispositivo.updateDispositivo")
    void updateDispositivo(
            @Param("p_id") Integer id,
            @Param("p_tipo") String tipo,
            @Param("p_manufacturador") String marca,
            @Param("p_modelo") String modelo,
            @Param("p_numero_serial") String serial,
            @Param("p_id_usuario") Integer idUsuario,
            @Param("p_status") String status
    );

    @Procedure(name = "Dispositivo.deleteDispositivo")
    void deleteDispositivo(@Param("p_id") Integer id);

    @Procedure(name = "Dispositivo.generarDispositivo")
    void generarDispositivo(
            @Param("p_tipo") String tipo,
            @Param("p_fabricante") String marca,
            @Param("p_modelo") String modelo,
            @Param("p_numero_serial") String serial
    );

    @Procedure(name = "Dispositivo.getDisponibles")
    List<Dispositivo> getDisponibles();

    @Procedure(name = "Dispositivo.getAsignados")
    List<Dispositivo> getAsignados();

    @Procedure(name = "Dispositivo.getPorTipo")
    List<TipoDispositivoCount> getPorTipo();

    @Procedure(name = "Dispositivo.getEnReparacion")
    List<Dispositivo> getEnReparacion();

}
