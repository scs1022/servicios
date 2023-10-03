package com.vinni.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinni.entidad.Vehiculo;

public interface VehiculoRepositorio extends JpaRepository<Vehiculo, String> {
    
}
