package com.vinni.repositorios;


import com.vinni.dto.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface  UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    
}
