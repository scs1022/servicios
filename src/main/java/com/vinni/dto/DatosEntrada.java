package com.vinni.dto;

import java.io.Serializable;

public class DatosEntrada implements Serializable{
    private int cedula;
    private String fecha;

    public DatosEntrada(int cedula, String fecha) {
        this.cedula = cedula;
        this.fecha = fecha;
    }

    public int getCedula() {
        return cedula;
    }
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    // empty constructor
    public DatosEntrada() {
        
    }

}
