package com.vinni.dto;

public class DatosSalida implements java.io.Serializable{
    private float saldo;
    private int cedula;
    private Banco banco;

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public DatosSalida(float saldo, int cedula, Banco banco) {
        this.saldo = saldo;
        this.cedula = cedula;
        this.banco = banco;
    }
    
    
}
