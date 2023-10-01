package com.vinni.dto;

public class Banco implements java.io.Serializable {
    private int nit;
    private String nombreRepresentante;

    public Banco(int nit, String nombreRepresentante) {
        this.nit = nit;
        this.nombreRepresentante = nombreRepresentante;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getNombreRepresentante() {
        return nombreRepresentante;
    }

    public void setNombreRepresentante(String nombreRepresentante) {
        this.nombreRepresentante = nombreRepresentante;
    }
    
}
