package com.proyecto.EasyIT.Model;


import com.proyecto.EasyIT.Model.Requests.TipoDispositivoCount;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name= "DISPOSITIVO")

@SqlResultSetMapping(
        name = "TipoDispositivoCountMapping",
        classes = @ConstructorResult(
                targetClass = TipoDispositivoCount.class,
                columns = {
                        @ColumnResult(name = "tipo_dispositivo", type = String.class),
                        @ColumnResult(name = "total", type = Long.class)
                }
        )
)

@NamedStoredProcedureQueries({

        //Insertar dispositivo completo
        @NamedStoredProcedureQuery(
                name = "Dispositivo.insertDispositivo",
                procedureName = "dispositivo_pkg.insert_dispositivo",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tipo", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_manufacturador", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_modelo", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numero_serial", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_usuario", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_status", type = String.class)
                }
        ),

        //Eliminar dispositivo
        @NamedStoredProcedureQuery(
                name = "Dispositivo.deleteDispositivo",
                procedureName = "dispositivo_pkg.delete_dispositivo",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id", type = Long.class)
                }
        ),

        //Actualizar dispositivo
        @NamedStoredProcedureQuery(
                name = "Dispositivo.updateDispositivo",
                procedureName = "dispositivo_pkg.update_dispositivo",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tipo", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_manufacturador", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_modelo", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numero_serial", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_usuario", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_status", type = String.class)
                }
        ),

        //Generar dispositivo sin usuario
        @NamedStoredProcedureQuery(
                name = "Dispositivo.generarDispositivo",
                procedureName = "dispositivo_pkg.sp_generar_dispositivo",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tipo", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_fabricante", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_modelo", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numero_serial", type = String.class)
                }
        ),

        //Obtener todos
        @NamedStoredProcedureQuery(
                name = "Dispositivo.getAll",
                procedureName = "dispositivo_pkg.get_all_dispositivos",
                resultClasses = Dispositivo.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class)
                }
        ),

        //Obtener por ID
        @NamedStoredProcedureQuery(
                name = "Dispositivo.getDispositivoById",
                procedureName = "dispositivo_pkg.get_dispositivo_by_id",
                resultClasses = Dispositivo.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name ="p_cursor" ,type = void.class)
                }
        ),

        //Vistas
        @NamedStoredProcedureQuery(
                name = "Dispositivo.getDisponibles",
                procedureName = "dispositivo_pkg.sp_get_dispositivos_disponibles",
                resultClasses = Dispositivo.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class)
                }
        ),

        @NamedStoredProcedureQuery(
                name = "Dispositivo.getAsignados",
                procedureName = "dispositivo_pkg.sp_get_dispositivos_asignados",
                resultClasses = Dispositivo.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class)
                }
        ),

        @NamedStoredProcedureQuery(
                name = "Dispositivo.getPorTipo",
                procedureName = "dispositivo_pkg.sp_get_dispositivos_por_tipo",
                resultSetMappings = "TipoDispositivoCountMapping",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class)
                }
        ),

        @NamedStoredProcedureQuery(
                name = "Dispositivo.getEnReparacion",
                procedureName = "dispositivo_pkg.sp_get_dispositivos_reparacion",
                resultClasses = Dispositivo.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class)
                }
        )

})

public class Dispositivo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID_Dispositivo")
    private int idDispositivo;
    private String TipoDispositivo;
    private String manufacturador;
    private String modelo;
    private Integer idUsuario;
    private String numeroSerial;
    private String statusActual;

}
