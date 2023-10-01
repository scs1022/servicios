package com.vinni.dto;

import java.io.Serializable;

public class Universidad implements Serializable{
    private String nombre;
    private String nit;
    public Universidad(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNit() {
        return nit;
    }
    public void setNit(String nit) {
        this.nit = nit;
    }
    
}
