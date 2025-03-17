package com.proyecto.EasyIT.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name= "ADMINISTRADOR")
public class Administrador implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID_ADMINISTRADOR")
    private int idAdministrador;


    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDOS")
    private String apellidos;
    @Column(name = "CORREO")
    private String correo;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "DEPARTAMENTO")
    private String departamento;


    public Administrador(String nombre, String apellidos, String correo, String password, String departamento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.password = password;
        this.departamento = departamento;
    }
}
