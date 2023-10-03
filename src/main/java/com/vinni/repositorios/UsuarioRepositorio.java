package com.vinni.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;

import com.vinni.entidad.Usuario;


public interface  UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    
}
