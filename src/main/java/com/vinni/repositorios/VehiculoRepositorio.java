package com.vinni.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinni.dto.Vehiculo;

public interface VehiculoRepositorio extends JpaRepository<Vehiculo, String> {
    
}
