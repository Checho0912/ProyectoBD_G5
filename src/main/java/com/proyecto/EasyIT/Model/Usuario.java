package com.proyecto.EasyIT.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;


public class Usuario implements Serializable {


    private Long idUsuario;
    private String nombre;
    private String apellidos;
    private String correo;
    private String departamento;

}
