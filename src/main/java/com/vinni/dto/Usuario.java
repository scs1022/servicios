// package com.vinni.dto;

// import java.io.Serializable;

// public class Usuario implements Serializable{
//     private String nombre;
//     private String apellidos;
//     public String getNombre() {
//         return nombre;
//     }
//     public void setNombre(String nombre) {
//         this.nombre = nombre;
//     }
//     public String getApellidos() {
//         return apellidos;
//     }
//     public void setApellidos(String apellidos) {
//         this.apellidos = apellidos;
//     }
//     public Usuario() {
//         super();
//     }
//     public Usuario(String nombre, String apellido) {
//         super();
//         this.nombre = nombre;
//         this.apellidos = apellido;
//     }
    
// }


package com.vinni.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Usuario(Long id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public Usuario() {
    }
    public Usuario(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
}
