package com.vinni.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.vinni.dto.Banco;
// import com.vinni.dto.DatosEntrada;
// import com.vinni.dto.DatosSalida;
// import com.vinni.dto.Universidad;
import com.vinni.dto.Usuario;
import com.vinni.dto.Vehiculo;
//import com.vinni.mock.Datos;
import com.vinni.repositorios.UsuarioRepositorio;
//import org.springframework.stereotype.Service;
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

    //private Datos datos = new Datos();

    @WebMethod(operationName = "adicionar")
    public void addUsuario(@WebParam Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }

    @WebMethod(operationName = "obtener")
    public List<Usuario> getUsuarios() {
        return usuarioRepositorio.findAll();
    }

    // @WebMethod(operationName = "obtener")
    // public List<Usuario> getUsuarios() {

    // return datos.usuariosList;
    // }

    // @WebMethod(operationName = "adicionar")
    // public void addUsuario(@WebParam Usuario usuario) {
    // datos.adicionarUsuario(usuario);
    // }

    // @WebMethod(operationName = "consultaUniversidad")
    // public Universidad consulta(@WebParam String nit) {
    //     return new Universidad("nit", "nit");
    // }

    // @WebMethod(operationName = "dataIn")
    // public DatosEntrada DataIn(@WebParam String cedula) {
    //     return new DatosEntrada(123, "28/9/23");
    // }

    // @WebMethod(operationName = "consultaSaldo")
    // public DatosSalida DataOut(@WebParam DatosEntrada datos) {
    //     // System.out.println(datos.getCedula());
    //     return new DatosSalida(23, 123, new Banco(123, "Miguel"));
    // }

    // @WebMethod(operationName = "consultaValorSeguro")
    // public Long consultaValorSeguro(@WebParam String placa) {
    // Vehiculo vehiculo = datos.consultarVehiculo(placa);
    // int modelo = vehiculo.getModelo();
    // int antiguedad = 2023 - modelo;
    // double porcentajeAntiguedad = antiguedad * 0.2; // 2% por cada 10 años
    // double porcentaje = (porcentajeAntiguedad / 100) + 0.1;

    // // Long Seguro = (long)
    // //
    // ((vehiculo.getPrecio()*0.1)+(vehiculo.getPrecio()*(porcentajeAntiguedad/100)));
    // Long Seguro = (long) (vehiculo.getPrecio() * porcentaje);

    // return Seguro;
    // }

    // @WebMethod(operationName = "consultaValorSeguro2")
    // public Long consultaValorSeguro2(@WebParam String placa) {
    //     Vehiculo vehiculo = datos.consultarVehiculo(placa);

    //     return vehiculo.consultarSeguro();
    // }

    // @WebMethod(operationName = "consultaValorSeguro3")
    // public Long consultaValorSeguro3(@WebParam String placa) {
    //     Vehiculo vehiculo = datos.consultarVehiculo(placa);

    //     return vehiculo.getValorSeguro();
    // }

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
    public Long consultaValorSeguro2(@WebParam(name = "placaVehiculo") String placa) {
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
    public Long consultaValorSeguro3(@WebParam(name = "placaVehiculo") String placa) {
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
    public boolean crearVehiculo(@WebParam(name = "placaVehiculo") String placa, @WebParam(name = "modeloVehiculo") int modelo, @WebParam(name = "precioVehiculo") long precio)  {
        try {
            // Verificar si ya existe un vehículo con la misma placa
            Optional<Vehiculo> existingVehiculo = vehiculoRepositorio.findById(placa);
            if (existingVehiculo.isPresent()) {
                // El vehículo ya existe, no se puede crear otro con la misma placa
                return false;
            } else {
                // Crear un nuevo vehículo
                Vehiculo vehiculo = new Vehiculo(placa, modelo, precio);
                vehiculoRepositorio.save(vehiculo);
                return true;
            }
        } catch (Exception e) {
            // Manejo de errores
            e.printStackTrace();
            return false;
        }
    }



}