package com.proyecto.EasyIT.Service;

import com.proyecto.EasyIT.Model.Usuario;

import java.util.List;

public interface UsuarioService {
    //Listar
    List<Usuario> findAll();

    //Guardar
    Usuario save(Usuario usuario);

    // Actualizar
    Usuario update(int id, Usuario usuario);

    //Eliminar
    void delete(int id);

}
