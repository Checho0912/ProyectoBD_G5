package com.proyecto.EasyIT.Dao;

import com.proyecto.EasyIT.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDAO extends JpaRepository<Usuario,String> {

}
