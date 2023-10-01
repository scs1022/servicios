package com.vinni.servicios;

import java.util.List;


import com.vinni.dto.Usuario;

import jakarta.jws.WebParam;


public interface ServiciosSOAP{
    
    
    public List<Usuario> getUsuarios();
     
    
    public void addUsuario(@WebParam Usuario user);

    
}
