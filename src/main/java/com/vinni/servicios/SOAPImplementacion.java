package com.vinni.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinni.entidad.Usuario;
import com.vinni.entidad.Vehiculo;
import com.vinni.repositorios.UsuarioRepositorio;

import com.vinni.repositorios.VehiculoRepositorio;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@Service
@WebService(serviceName = "usuarios")
public class SOAPImplementacion {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private VehiculoRepositorio vehiculoRepositorio;

    // private Datos datos = new Datos();

    @WebMethod(operationName = "adicionar")
    private void addUsuario(@WebParam Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }

    @WebMethod(operationName = "obtener")
    private List<Usuario> getUsuarios() {
        return usuarioRepositorio.findAll();
    }

    @WebMethod(operationName = "obtenerVehiculos")
    public List<Vehiculo> consultarVehiculos() {
        return vehiculoRepositorio.findAll();
    }

    @WebMethod(operationName = "obtenerVehiculo")
    public Vehiculo obtenerVehiculo(@WebParam(name = "placaVehiculo") String placa){
        Vehiculo vehiculo = vehiculoRepositorio.findById(placa).orElse(null);
        return vehiculo;
    }

    @WebMethod(operationName = "consultaValorSeguro")
    public Long consultaValorSeguro(@WebParam(name = "placaVehiculo") String placa) {
        Vehiculo vehiculo = vehiculoRepositorio.findById(placa).orElse(null);

        if (vehiculo == null) {

            return null;
        }

        int modelo = vehiculo.getModelo();
        int antiguedad = 2023 - modelo;
        double porcentajeAntiguedad = antiguedad * 0.2; // 2% por cada 10 años
        double porcentaje = (porcentajeAntiguedad / 100) + 0.1;

        Long Seguro = (long) (vehiculo.getPrecio() * porcentaje);

        return Seguro;
    }

    @WebMethod(operationName = "consultaValorSeguro2")
    private Long consultaValorSeguro2(@WebParam(name = "placaVehiculo") String placa) {
        Optional<Vehiculo> vehiculoOptional = vehiculoRepositorio.findById(placa);
        if (vehiculoOptional.isPresent()) {
            Vehiculo vehiculo = vehiculoOptional.get();
            return vehiculo.consultarSeguro();
        } else {
            // Manejo de vehículo no encontrado
            return null;
        }
    }

    @WebMethod(operationName = "consultaValorSeguro3")
    private Long consultaValorSeguro3(@WebParam(name = "placaVehiculo") String placa) {
        Optional<Vehiculo> vehiculoOptional = vehiculoRepositorio.findById(placa);
        if (vehiculoOptional.isPresent()) {
            Vehiculo vehiculo = vehiculoOptional.get();
            return vehiculo.getValorSeguro();
        } else {
            // Manejo de vehículo no encontrado
            return null;
        }
    }

    @WebMethod(operationName = "crearVehiculo")
    public boolean crearVehiculo(@WebParam(name = "placaVehiculo") String placa,
            @WebParam(name = "modeloVehiculo") int modelo, @WebParam(name = "precioVehiculo") long precio,
            @WebParam(name = "ultimoAnoSOAT") int ultimoAnoPagoSOAT) {
        try {
            // Verificar si ya existe un vehículo con la misma placa
            Optional<Vehiculo> existingVehiculo = vehiculoRepositorio.findById(placa);
            if (existingVehiculo.isPresent()) {
                // El vehículo ya existe, no se puede crear otro con la misma placa
                return false;
            } else {
                // Crear un nuevo vehículo
                Vehiculo vehiculo = new Vehiculo(placa, modelo, precio, ultimoAnoPagoSOAT);
                vehiculoRepositorio.save(vehiculo);
                return true;
            }
        } catch (Exception e) {
            // Manejo de errores
            e.printStackTrace();
            return false;
        }
    }

    @WebMethod(operationName = "consultarSOAT")
    public String consultarSOAT(@WebParam(name = "placaVehiculo") String placa) {
        Vehiculo vehiculo = vehiculoRepositorio.findById(placa).orElse(null);
        if (vehiculo == null) {
            return "Vehículo no encontrado";
        }

        int modelo = vehiculo.getModelo();
        int antiguedad = 2023 - modelo;
        Long valorSOAT;
        String estado;

        if (antiguedad < 5) {
            valorSOAT = 100000L;
        } else {
            valorSOAT = 150000L;
        }

        // Verificar si el SOAT está pagado
        if (vehiculo.getUltimoAnoPagoSOAT() == 2023) {
            estado = "Activo"; // Pagado
        } else {
            estado = "Inactivo"; // No pagado
        }

        return "Valor SOAT: " + valorSOAT + ", Estado: " + estado;
    }

    @WebMethod(operationName = "consultarTodoRiesgo")
    public Long consultarTodoRiesgo(@WebParam(name = "placaVehiculo") String placa) {
        Vehiculo vehiculo = vehiculoRepositorio.findById(placa).orElse(null);
        if (vehiculo == null) {
            return null;
        }

        double porcentaje = 0.05; // 5%
        Long valorSeguroTodoRiesgo = (long) (vehiculo.getPrecio() * porcentaje);

        return valorSeguroTodoRiesgo;
    }
}