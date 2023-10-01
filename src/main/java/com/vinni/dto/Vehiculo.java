// package com.vinni.dto;


// public class Vehiculo implements java.io.Serializable{
    
//     private String placa;
//     private int modelo;
//     private long precio;
//     private Long ValorSeguro;

    
//     public String getPlaca() {
//         return placa;
//     }
    
//     public void setPlaca(String placa) {
//         this.placa = placa;
//     }

//     public int getModelo() {
//         return modelo;
//     }

//     public void setModelo(int modelo) {
//         this.modelo = modelo;
//     }

//     public long getPrecio() {
//         return precio;
//     }

//     public void setPrecio(long precio) {
//         this.precio = precio;
//     }

//     public Vehiculo(String placa, int modelo, long precio) {
//         this.placa = placa;
//         this.modelo = modelo;
//         this.precio = precio;
//     }
    
//     public Vehiculo() {
//     }

//     public Long getValorSeguro() {
//         return ValorSeguro;
//     }

//     public Long consultarSeguro(){
//         int antiguedad = 2023 - this.modelo;
//         double porcentajeAntiguedad = antiguedad * 0.002; // 2% por cada 10 años
//         return this.ValorSeguro = (long) (this.precio * (0.1 + porcentajeAntiguedad));
//     }
// }

package com.vinni.dto;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Vehiculo implements Serializable {
    @Id
    private String placa;
    private int modelo;
    private long precio;
    @Transient
    private Long ValorSeguro;


    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public int getModelo() {
        return modelo;
    }
    public void setModelo(int modelo) {
        this.modelo = modelo;
    }
    public long getPrecio() {
        return precio;
    }
    public void setPrecio(long precio) {
        this.precio = precio;
    }
    public Long getValorSeguro() {
        return ValorSeguro;
    }
    

    public Vehiculo(String placa, int modelo, long precio) {
        this.placa = placa;
        this.modelo = modelo;
        this.precio = precio;
    }


    public Long consultarSeguro() {
        int antiguedad = 2023 - this.modelo;
        double porcentajeAntiguedad = antiguedad * 0.002; // 2% por cada 10 años
        this.ValorSeguro = (long) (this.precio * (0.1 + porcentajeAntiguedad));
        return this.ValorSeguro;
    }
    public Vehiculo() {
    }
}
